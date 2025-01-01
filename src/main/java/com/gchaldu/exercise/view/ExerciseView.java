package com.gchaldu.exercise.view;

import com.gchaldu.exercise.controller.ExerciseController;
import com.gchaldu.exercise.model.entity.Exercise;

import java.util.Scanner;

public class ExerciseView {
    Scanner scanner = new Scanner(System.in);

    public void start(ExerciseController exerciseController){

        String choise;
        boolean exit=true;
        while (exit){
            displayMenu();
            choise = scanner.nextLine();
            switch (choise){
                case "1":{
                    add(exerciseController);
                    break;
                }
                case "2":{
                    list(exerciseController);
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
        System.out.println("1- Add Exercise");
        System.out.println("2- List Exercise");
        System.out.println("3- Delete Exercise");
        System.out.println("4- Update Exercise");
        System.out.println("5- Exit");
    }

    public void add(ExerciseController exerciseController){
        System.out.println("Enter the name exercise");
        String name = scanner.nextLine();

        System.out.println("Enter duration of the exercise");
        Integer duration = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter muscle group");
        String muscleGroup = scanner.nextLine();

        exerciseController.addExercise(name,duration,muscleGroup);
    }

    public void list(ExerciseController exerciseController){
        exerciseController.getMapExercise().forEach((s, exercise) -> {
            view(exercise);
        });
    }

    public void view(Exercise exercise){
        System.out.println("Exercise ID: " + exercise.getId());
        System.out.println("Exercise name: " + exercise.getName());
        System.out.println("Exercise Duration: " + exercise.getDuration());
        System.out.println("Exercise Muscle Group: " + exercise.getMouscleGroup());
    }
}
