package com.gchaldu.exercise.model.entity;

public class Exercise {
    private Long id;
    private static Long counter=0L;
    private String name;
    private Integer duration;//repeticiones o tiempo
    private String mouscleGroup;

    public Exercise(String name, Integer duration, String mouscleGroup) {
        this.name = name;
        this.duration = duration;
        this.mouscleGroup = mouscleGroup;
        this.id = ++counter;
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
        Exercise.counter = counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getMouscleGroup() {
        return mouscleGroup;
    }

    public void setMouscleGroup(String mouscleGroup) {
        this.mouscleGroup = mouscleGroup;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", mouscleGroup='" + mouscleGroup + '\'' +
                '}';
    }
}
