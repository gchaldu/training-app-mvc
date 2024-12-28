package com.gchaldu.training.model.repository;

import com.gchaldu.training.exception.TrainingNotFoundException;
import com.gchaldu.training.model.entity.Training;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TrainingRepository {
    List<Training> trainings;

    public TrainingRepository() {
        this.trainings = new ArrayList<>();
    }

    public boolean addTraining(Training training){
        if(training==null){
            throw new IllegalArgumentException("El training no puede ser nulo");
        }
        if (trainings.contains(training)) {
            System.out.println("El entrenamiento ya existe en la lista.");
            return false; // Indica que no se añadió porque ya existía
        }
        return trainings.add(training);
    }

    public List<Training> findAllTraining(){
        return trainings;
    }

    public Optional<Training> getTrainingById(Long id){
        if (id == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        return trainings.stream()
                .filter(training -> training.getId().equals(id))
                .findAny();

    }

    public boolean deleteTrainning(Training training){
        if(training==null){
            throw new IllegalArgumentException("El training no puede ser nulo");
        }
        if(!trainings.contains(training)){
             throw new TrainingNotFoundException("El entrenamiento no se encuentra en la lista");
        }

        return trainings.remove(training);
    }

    public Training updateTraining(Long id, Training training){
        if(training == null || id ==null){
            throw new IllegalArgumentException("No puede haber argumentos nulos");
        }

        int index = -1;
        for (int i=0; i<trainings.size(); i++){
            if(trainings.get(i).getId().equals(id)){
                index = i;
                break;
            }
        }

        if(index==-1){
            throw new TrainingNotFoundException("El training no existe");
        }
        // Validar que el ID del entrenamiento actualizado coincide
        if (!training.getId().equals(id)) {
            throw new IllegalArgumentException("El ID del entrenamiento actualizado no coincide con el ID proporcionado");
        }

        return trainings.set(index, training);
    }
}
