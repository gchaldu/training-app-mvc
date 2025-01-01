package com.gchaldu.coach.model.repository;

import com.gchaldu.coach.model.entity.Coach;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class CoachRepository {
    private final Set<Coach> coachList;

    public CoachRepository() {
        coachList = new HashSet<>();
    }

    public void addCoach(Coach coach){
        if(coach==null){
            throw new IllegalArgumentException("The coach cannot null");
        }
        boolean exists = coachList.add(coach);

        if (!exists){
            throw new IllegalArgumentException("The coach already exists");
        }
    }

    public void deleteCoach(Coach coach){
        if(coach==null){
            throw new IllegalArgumentException("The coach cannot be null");
        }
        if (!coachList.remove(coach)) {
            throw new IllegalArgumentException("The coach does not exist");
        }
    }

    public Optional<Coach> getCoachById(String id){
        if(id==null){
            throw new IllegalArgumentException("NAME is null or empty");
        }

        return coachList.stream().filter(coach -> coach.getId().equals(id)).findAny();
    }

    public Optional<Coach> getCoachByName(String name){
        if(name==null || name.isBlank()){
            throw new IllegalArgumentException("NAME is null or empty");
        }

        return coachList.stream().filter(coach -> coach.getName().equals(name)).findAny();
    }

    public void updateCoach(String id, Coach coach){
        if(id==null || coach==null){
            throw new IllegalArgumentException("ID or Coach is null");
        }
        try {
            UUID.fromString(id); // Intentar parsear el UUID

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("The ID is not a UUID");
        }
        Optional<Coach> existingCoach = getCoachById(id);
        System.out.println("existingCoach.get() = " + existingCoach.get());
        if (existingCoach.isEmpty()) {
            throw new IllegalArgumentException("The coach does not exist");
        }

        deleteCoach(existingCoach.get());
        coachList.add(coach);
    }

    public Set<Coach> getCoachList() {
        return coachList;
    }
}
