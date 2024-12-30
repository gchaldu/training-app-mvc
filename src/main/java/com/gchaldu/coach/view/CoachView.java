package com.gchaldu.coach.view;

import com.gchaldu.coach.controller.CoachController;
import com.gchaldu.coach.exceptions.CoachNotFoundException;
import com.gchaldu.coach.model.entity.Coach;

import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class CoachView {
    Scanner scanner = new Scanner(System.in);

    public void start(CoachController controller){
        String choise;
        boolean exit=true;
        while (exit){
            displayMenu();
            choise = scanner.nextLine();
            switch (choise){
                case "1":{
                    add(controller);
                    break;
                }
                case "2":{
                    list(controller);
                    break;
                }
                case "3":{
                    delete(controller);
                    break;
                }
                case "4":{
                    update(controller);
                    break;
                }
                case "5":{
                    exit=false;
                    break;
                }
            }
        }
    }

    public void displayMenu(){
        System.out.println("1 - Add Coach");
        System.out.println("2 - List Coach");
        System.out.println("3 - Delete Coach");
        System.out.println("4 - Update Coach");
        System.out.println("5 - Exit");
    }

    public void add(CoachController controller){
        System.out.println("Enter the Coach name");
        String name = scanner.nextLine();

        String expertise;
        while (true) {
            System.out.println("Enter the Coach expertise [Health, Sport, Fitness]:");
            expertise = scanner.nextLine();
            if (Set.of("Health", "Sport", "Fitness").contains(expertise)) {
                break;
            }
            System.out.println("Invalid expertise. Please choose from [Health, Sport, Fitness].");
        }

        controller.addCoach(name, expertise);
    }

    public void delete(CoachController controller){
        try {
            Optional<Coach> coach = getOptCoach(controller);
            coach.ifPresentOrElse(
                    coach1 -> controller.deleteCoach(coach1),
                    () -> System.out.println("The Coach not found")
            );
        } catch (CoachNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public Optional<Coach> getOptCoach(CoachController controller) throws CoachNotFoundException {
        System.out.println("Enter Name of the Coach");
        String name = scanner.nextLine();

        Optional<Coach> optionalCoach = controller.getCoach(name);

        if(!optionalCoach.isPresent()){
            throw new CoachNotFoundException("Coach not found");
        }
        return optionalCoach;
    }

    public void list(CoachController controller){
        controller.getListCoaches().forEach(coach -> {
            view(coach);
        });
    }

    public void update(CoachController controller){
        //Buscar el Coach
        Optional<Coach> coach = null;
        try {
            coach = getOptCoach(controller);
            //Mostrar los datos actuales
            System.out.println("ID: " + coach.get().getId());
            System.out.println("The coach current name " + coach.get().getName());

            //Ingresar los nuevos datos
            System.out.println("Enter the coach new name");
            String name = scanner.nextLine();

            System.out.println("The coach current expertise " + coach.get().getExpertise());
            System.out.println("Enter the coach new expertise");
            String expertise = scanner.nextLine();

            //Llamar al controlador para actualizar, con Id Viejo y los nuevos datos
            controller.updateCoach(coach.get().getId(), name, expertise);
        } catch (CoachNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void view(Coach coach){
        System.out.println("-----------------------------------");
        System.out.println("Id: " + coach.getId());
        System.out.println("Name: " + coach.getName());
        System.out.println("Expertise: " + coach.getExpertise());
        System.out.println("-----------------------------------");
    }
}
