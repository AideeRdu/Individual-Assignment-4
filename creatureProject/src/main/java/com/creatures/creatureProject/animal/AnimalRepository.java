package com.creatures.creatureProject.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    List<Animal> findByDescription(String description);

    @Query(value = "select * from animals s where s.name like %?1%", nativeQuery = true)
    List<Animal> getAnimalByName(String name);

    @Query(value = "select * from animals i where i.description like %?1%", nativeQuery = true)
    List<Animal> getAnimalDescription(String name);

}
