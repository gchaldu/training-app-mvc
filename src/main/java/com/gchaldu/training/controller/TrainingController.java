package com.gchaldu.training.controller;

import com.gchaldu.training.model.entity.Training;
import com.gchaldu.training.model.repository.TrainingRepository;

import java.util.Optional;

public class TrainingController {

    private TrainingRepository repository;

    public TrainingController(TrainingRepository repository) {
        this.repository = repository;
    }

    public void createTraining(String name, String intensity){
        Training training = new Training(name, intensity);
        repository.addTraining(training);
    }

    public void removeTraining(Long id){
        Optional<Training> optionalTraining = repository.getTrainingById(id);
        optionalTraining.ifPresentOrElse(
                training -> repository.deleteTrainning(training),
                () -> System.out.println("The training is not exist")
        );
    }

    public void updateTraining(Long id, Training training){
        repository.updateTraining(id, training);
    }

    public Optional<Training> getTraining(Long id){
        return repository.getTrainingById(id);
    }

    public TrainingRepository getRepository() {
        return repository;
    }

    public void setRepository(TrainingRepository repository) {
        this.repository = repository;
    }
}
