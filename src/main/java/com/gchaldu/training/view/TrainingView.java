package com.gchaldu.training.view;

import com.gchaldu.training.controller.TrainingController;
import com.gchaldu.training.exception.IdIsLessThanZeroException;
import com.gchaldu.training.model.entity.Training;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class TrainingView {
    Scanner scanner = new Scanner(System.in);

    public void start(TrainingController trainingController){
        String choice;
        Boolean out=true;
        while (out){
            displayMenu();
            System.out.println("Select options");
            choice = scanner.nextLine();
            switch (choice){
                case "1":{
                    add(trainingController);
                    break;
                }
                case "2":{
                    list(trainingController);
                    break;
                }
                case "3":{
                    delete(trainingController);
                    break;
                }
                case "4":{
                    update(trainingController);
                    break;
                }
                case "5":{
                    out=false;
                }

            }
        }
    }

    public void displayMenu(){
        System.out.println("1 - Add Training");
        System.out.println("2 - List Training");
        System.out.println("3 - Remove Training");
        System.out.println("4 - Update Training");
        System.out.println("5 - Exit");
    }

    public void add(TrainingController trainingController){
        System.out.println("Enter the Trainee name");
        String name = scanner.nextLine();
        System.out.println("Enter the training intensity\nHalf, High or Low");
        String intensity = scanner.nextLine();
        trainingController.createTraining(name,intensity);
    }

    public void delete(TrainingController trainingController){
        Optional<Training> optionalTraining = getOptionalTraining(trainingController);

        optionalTraining.ifPresentOrElse(
                training -> trainingController.removeTraining(training.getId()),
                () -> System.out.println("The training is not exist")
                );
    }

    public void update(TrainingController trainingController){
        Optional<Training> trainingOptional = getOptionalTraining(trainingController);

        trainingOptional.ifPresentOrElse(
                training -> {
                    view(training);
                    training = updateFieldTraining(training);
                    trainingController.updateTraining(training.getId(), training);
                },
                () -> System.out.println("The training not found")
                );

    }

    public Training updateFieldTraining(Training training){
        System.out.println("Current Trainee: " + training.getName());
        System.out.println("ENTER NEW name of Trainee");
        String name = scanner.nextLine();
        training.setName(name);

        System.out.println("Current intensity: " + training.getIntensity());
        System.out.println("Enter intensity training\nHalf, High or Low");
        String intensity = scanner.nextLine();
        training.setIntensity(intensity);
        return training;
    }

    public void list(TrainingController trainingController){
        System.out.println("LIST OF THE TRAINING");
        trainingController.getRepository().findAllTraining().forEach(training -> {
            view(training);
        });
    }

    /*Utilidades*/
    public Optional<Training> getOptionalTraining(TrainingController trainingController){
        Long id=0L;
        try{
            System.out.println("Enter the training ID");
            id = scanner.nextLong();
            if(id<0){
                throw new IdIsLessThanZeroException("El dato ingresado no puede ser negativo");
            }
            scanner.nextLine();
        }catch (InputMismatchException e){
            System.out.println("El id debe ser un numero");
        }catch (IdIsLessThanZeroException e){
            System.out.println(e.getMessage());
        }
        return trainingController.getTraining(id);
    }

    public void view(Training training){
        System.out.println("---------------------------------------");
        System.out.println("ID: " + training.getId());
        System.out.println("Trainee: " + training.getName());
        System.out.println("Intensity: " + training.getIntensity());
        System.out.println("---------------------------------------");
    }
}
