package com.gchaldu.exercise.model.repository;

import com.gchaldu.exercise.model.entity.Exercise;
import com.gchaldu.utils.ValidationUtils;

import java.util.HashMap;
import java.util.Map;

public class ExerciseRepository {

    private final Map<String, Exercise> exerciseMap = new HashMap<>();

    public void addExercise(Exercise exercise){
        if(exercise==null || !ValidationUtils.isValidUUID(exercise.getId())){
            throw new IllegalArgumentException("The exercise is null or its ID is not a valid UUID.");
        }
        if (exerciseMap.containsKey(exercise.getId())) {
            throw new IllegalArgumentException("An exercise with this ID already exists");
        }
        exerciseMap.put(exercise.getId(), exercise);
    }

    public Map<String, Exercise> getExerciseMap() {
        return exerciseMap;
    }
}
