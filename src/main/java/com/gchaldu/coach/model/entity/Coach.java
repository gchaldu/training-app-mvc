package com.gchaldu.coach.model.entity;

public class Coach {
    private Long id;
    private static Long counter=0L;
    private String name;
    private String expertise;

    public Coach(String name, String expertise) {
        this.name = name;
        this.expertise = expertise;
        this.id=++counter;
    }

    public static Long getCounter() {
        return counter;
    }

    public static void setCounter(Long counter) {
        Coach.counter = counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", expertise='" + expertise + '\'' +
                '}';
    }
}
