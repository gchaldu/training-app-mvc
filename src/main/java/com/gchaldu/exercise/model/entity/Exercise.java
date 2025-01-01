package com.gchaldu.exercise.model.entity;

import java.util.UUID;

public class Exercise {
    private String id;
    private String name;
    private Integer duration;//repeticiones o tiempo
    private String mouscleGroup;

    public Exercise(String name, Integer duration, String mouscleGroup) {
        this.name = name;
        this.duration = duration;
        this.mouscleGroup = mouscleGroup;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
