package com.creatures.creatureProject.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService{

    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> getAllAnimals(){
        return animalRepository.findAll();
    }

    public Animal getAnimalbyID(int animalID){
        return animalRepository.findById(animalID).orElse(null);
    }

    public List<Animal> getAnimalByName(String animalName){
        return animalRepository.getAnimalByName(animalName);
    }

    public List<Animal> getAnimalDescription(String animalDescription){
        return animalRepository.getAnimalDescription(animalDescription);
    }

    public void addNewAnimal(Animal animal){
        animalRepository.save(animal);
    }

    public void updateAnimal(int animalId, Animal animal){
        Animal existing = getAnimalbyID(animalId);
        existing.setName(animal.getName());
        existing.setDescription(animal.getDescription());



        animalRepository.save(existing);
    }

    public void deleteAnimalByID(int animalId) {

        animalRepository.deleteById(animalId);
    }


}