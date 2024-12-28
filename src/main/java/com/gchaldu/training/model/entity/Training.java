package com.gchaldu.training.model.entity;

import com.gchaldu.coach.model.entity.Coach;
import com.gchaldu.exercise.model.entity.Exercise;

import java.util.ArrayList;
import java.util.List;

public class Training {

    private Long id;
    private static Long counter=0L;
    private String name;//nombre del entrenado
    private String intensity;//alta, media, baja
    private List<Exercise> exercises;
    private Coach coach;

    public Training(String name, String intensity) {
        this.name = name;
        this.intensity = intensity;
        this.id = ++counter;
    }

    public Training(String name, String intensity, Coach coach) {
        this.name = name;
        this.intensity = intensity;
        this.coach = coach;
        this.id = ++counter;
        this.exercises = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static Long getCounter() {
        return counter;
    }

    public static void setCounter(Long counter) {
        Training.counter = counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", intensity='" + intensity + '\'' +
                ", coach=" + coach.getName() +
                '}';
    }
}
