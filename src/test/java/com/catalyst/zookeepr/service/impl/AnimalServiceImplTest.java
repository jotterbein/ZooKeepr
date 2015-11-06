package com.catalyst.zookeepr.service.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.catalyst.zookeepr.entities.Animal;
import com.catalyst.zookeepr.entities.Enclosure;
import com.catalyst.zookeepr.repository.AnimalRepository;
import com.catalyst.zookeepr.repository.EnclosureRepository;

public class AnimalServiceImplTest {

	AnimalRepository repository;
	
	AnimalServiceImpl target;
	
	@Before
	public void setUp() {
		target = new AnimalServiceImpl();
		repository = Mockito.mock(AnimalRepository.class);
		target.setAnimalRepository(repository);
	}
	
	@Test
	public void testGetAnimals() {
		target.getAnimals();
		Mockito.verify(repository).findAll();
	}
	
	@Test
	public void testCreateAnimals() {
		Animal an = new Animal();
		target.createAnimal(an);
		Mockito.verify(repository).save(an);
	}
	
	@Test
	public void testUpdateAnimal() {
		Animal an = new Animal();
		target.updateAnimal(an);
		Mockito.verify(repository).save(an);
	}
	
	@Test
	public void testGetAnimalById() {
		long id = (long) 1.0;
		target.getAnimalById(id);
		Mockito.verify(repository).findOne(id);
	}
	

}