package com.gchaldu.exercise.controller;

import com.gchaldu.exercise.model.entity.Exercise;
import com.gchaldu.exercise.model.repository.ExerciseRepository;

import java.util.Map;

public class ExerciseController {
    private ExerciseRepository repository;

    public ExerciseController(ExerciseRepository repository) {
        this.repository = repository;
    }

    public void addExercise(String name, Integer duration, String muscleGroup){
        Exercise exercise = new Exercise(name,duration,muscleGroup);
        repository.addExercise(exercise);
    }

    public Map<String, Exercise> getMapExercise() {
        return repository.getExerciseMap();
    }

    public void setRepository(ExerciseRepository repository) {
        this.repository = repository;
    }
}
