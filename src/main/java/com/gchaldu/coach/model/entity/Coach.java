package com.gchaldu.coach.model.entity;

import java.util.Objects;
import java.util.UUID;

public class Coach {
    private String id;
    private String name;
    private String expertise;


    public Coach(String name, String expertise) {
        this.name = name;
        this.expertise = expertise;
        this.id = UUID.randomUUID().toString();
    }

    public Coach(String id, String name, String expertise) {
        this.name = name;
        this.expertise = expertise;
        this.id = id;
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

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coach coach = (Coach) o;
        return Objects.equals(id, coach.id) && Objects.equals(name, coach.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
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
