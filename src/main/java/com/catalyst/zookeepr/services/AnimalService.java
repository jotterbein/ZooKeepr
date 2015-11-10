package com.catalyst.zookeepr.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.catalyst.zookeepr.entities.Animal;

public interface AnimalService {

	/**
	 * Returns a list of all animals in the database
	 * @return: A list of all animals
	 */
	List<Animal> getAnimals();
	
	/**
	 * Adds a new animal to the databsae
	 * @param animal: Animal to be added
	 */
	Animal createAnimal(Animal animal);
	
	/**
	 * Updates an animal in the database
	 * @param animal: The animal to be updated
	 */
	Animal updateAnimal(Animal animal);
	
	Animal getAnimalById(long id);
}
