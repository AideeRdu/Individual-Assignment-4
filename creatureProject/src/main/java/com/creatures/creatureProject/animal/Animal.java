package com.creatures.creatureProject.animal;

import jakarta.persistence.*;

@Entity
@Table(name="animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int animalID;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String description;

    public Animal(int animalID, String name, String description) {
        this.animalID = animalID;
        this.name = name;
        this.description = description;
    }
    public Animal(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Animal() {}

    public void setAnimalID(int animalID) {
        this.animalID = animalID;
    }

    public int getAnimalID() {
        return animalID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
