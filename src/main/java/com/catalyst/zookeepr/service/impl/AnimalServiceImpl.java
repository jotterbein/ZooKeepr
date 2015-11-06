package com.catalyst.zookeepr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.zookeepr.entities.Animal;
import com.catalyst.zookeepr.repository.AnimalRepository;
import com.catalyst.zookeepr.services.AnimalService;

@Service
public class AnimalServiceImpl implements AnimalService{

	@Autowired
	private AnimalRepository repository;
	
	@Override
	public List<Animal> getAnimals() {
		return repository.findAll();
	}

	@Override
	public void createAnimal(Animal animal) {
		repository.save(animal);
	}

	@Override
	public void updateAnimal(Animal animal) {
		repository.save(animal);		
	}

	@Override
	public Animal getAnimalById(long id) {
		return repository.findOne(id);
	}

}
