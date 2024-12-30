package com.gchaldu.coach.controller;

import com.gchaldu.coach.model.entity.Coach;
import com.gchaldu.coach.model.repository.CoachRepository;

import java.util.Optional;
import java.util.Set;

public class CoachController {

    private final CoachRepository coachRepository;

    public CoachController(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    public void addCoach(String name, String expertise){
        Coach coach = new Coach(name, expertise);
        coachRepository.addCoach(coach);
    }

    public void deleteCoach(Coach coach){
        coachRepository.deleteCoach(coach);
    }

    public void updateCoach(String id, String name, String expertise){
        Coach coach = new Coach(name, expertise);
        coachRepository.updateCoach(id, coach);
    }

    public Optional<Coach> getCoach(String name){
        return coachRepository.getCoachByName(name);
    }

    public Set<Coach> getListCoaches(){
        return coachRepository.getCoachList();
    }
}
