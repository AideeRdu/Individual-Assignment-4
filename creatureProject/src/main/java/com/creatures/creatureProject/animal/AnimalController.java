package com.creatures.creatureProject.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/creatures")

public class AnimalController{
    @Autowired
    private AnimalService service;

    @GetMapping("/all")
    public Object getAllAnimals(){
        return new ResponseEntity<>(service.getAllAnimals(), HttpStatus.OK);
    }

    @GetMapping("/{animalId}")
    public Object getOneAnimal(@PathVariable int animalId) {
        return new ResponseEntity<>(service.getAnimalbyID(animalId), HttpStatus.OK);

    }

    @GetMapping("/name")
    public Object getAnimalName(@RequestParam(name = "search", defaultValue = "") String search) {
        return new ResponseEntity<>(service.getAnimalByName(search), HttpStatus.OK);
    }

    @GetMapping("/description/{description}")
    public Object getAnimalDescription(@PathVariable String description) {
        return new ResponseEntity<>(service.getAnimalDescription(description), HttpStatus.OK);
    }

    @PostMapping("/new")
    public Object addNewAnimal(@RequestBody Animal animal) {
        service.addNewAnimal(animal);
        return new ResponseEntity<>(service.getAllAnimals(), HttpStatus.CREATED);
    }

    @PutMapping("/update/{animalID}")
    public Object updateAnimal(@PathVariable int animalID, @RequestBody Animal animal) {
        service.updateAnimal(animalID, animal);
        return new ResponseEntity<>(service.getAnimalbyID(animalID), HttpStatus.CREATED);

    }

    @DeleteMapping("/delete/{animalID}")
    public Object deleteAnimalByID(@PathVariable int animalID) {
        service.deleteAnimalByID(animalID);
        return new ResponseEntity<>(service.getAllAnimals(), HttpStatus.OK);
    }

}
