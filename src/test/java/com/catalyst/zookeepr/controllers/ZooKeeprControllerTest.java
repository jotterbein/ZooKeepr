package com.catalyst.zookeepr.controllers;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.catalyst.zookeepr.controller.ZooKeeprController;
import com.catalyst.zookeepr.entities.Animal;
import com.catalyst.zookeepr.entities.Enclosure;
import com.catalyst.zookeepr.entities.Food;
import com.catalyst.zookeepr.services.AnimalService;
import com.catalyst.zookeepr.services.EnclosureService;
import com.catalyst.zookeepr.services.FoodService;
import com.catalyst.zookeepr.validator.Validator;

public class ZooKeeprControllerTest {

	private ZooKeeprController target;
	private EnclosureService enService;
	private AnimalService anService;
	private FoodService foodService;
	private Enclosure enclosure;
	private Animal animal;
	private Food food;
	private List<Enclosure> enList;
	private List<Animal> anList;
	private List<Food> foodList;
	
	@Before
	public void setup() {
		target = new ZooKeeprController();
		enService = Mockito.mock(EnclosureService.class);
		anService = Mockito.mock(AnimalService.class);
		foodService = Mockito.mock(FoodService.class);
		target.setAnimalService(anService);
		target.setEnclosureService(enService);
		target.setFoodService(foodService);
		enclosure = new Enclosure();
		animal = new Animal();
		food = new Food();
		enList = new ArrayList<Enclosure>();
		anList = new ArrayList<Animal>();
		foodList = new ArrayList<Food>();
		enclosure.setId(0);
		enclosure.setName("Name");
		enclosure.setCondition("Condition");
		enclosure.sethour(1);
		enclosure.setMinute(1);
		enclosure.setNumber(1);
		enclosure.setAnimal(1);
		enList.add(enclosure);
		food.setCategory("Fruit");
		food.setId(0);
		food.setName("Name");
		food.setVendor("Vendor");
		foodList.add(food);
		animal.setFood(1);
		animal.setId(0);
		animal.setName("Name");
		animal.setScienceName("Science");
		animal.setUrl("httpL//wikipedia.org");
		anList.add(animal);
		foodService.createFood(food);
		enService.createEnclosure(enclosure);
		anService.createAnimal(animal);
		Mockito.when(enService.getEnclosures()).thenReturn(enList);
		Mockito.when(anService.getAnimals()).thenReturn(anList);
		Mockito.when(foodService.getFoods()).thenReturn(foodList);
		
	}
	
	@Test
	public void testGetEnclosures() {
		List<Enclosure> enclosures = target.getEnclosures();
		assertFalse(enclosures.isEmpty());
	}
	
	@Test
	public void testAddEnclosure() {
		Mockito.when(enService.createEnclosure(Mockito.any())).thenReturn(enclosure);
		Enclosure en = target.addEnclosure(enclosure);
		Mockito.verify(enService, Mockito.atLeast(2)).createEnclosure(enclosure);
		assertEquals(enclosure, en);
	}
	
	@Test
	public void testUpdateEnclosure() {
		Mockito.when(enService.updateEnclosure(Mockito.any())).thenReturn(enclosure);
		Enclosure en = target.updateEnclosure(enclosure);
		Mockito.verify(enService).updateEnclosure(enclosure);
		assertEquals(enclosure, en);
	}
	
	@Test
	public void testDeleteEnclosure() {
		long id = 1;
		target.deleteEnclosure(id);
		Mockito.verify(enService).deleteEnclosure(id);
	}
	
	@Test
	public void testGetAnimals() {
		List<Animal> animals = target.getAnimals();
		assertEquals(1, animals.size());
	}
	
	@Test
	public void testCreateAnimal() {
		Mockito.when(anService.createAnimal(Mockito.any())).thenReturn(animal);
		Animal an = target.addAnimal(animal);
		Mockito.verify(anService, Mockito.atLeast(2)).createAnimal(animal);
		assertEquals(animal, an);
	}
	
	@Test
	public void testUpdateAnimal() {
		Mockito.when(anService.updateAnimal(Mockito.any())).thenReturn(animal);
		Animal an = target.updateAnimal(animal);
		Mockito.verify(anService).updateAnimal(animal);
		assertEquals(animal, an);
	}
}
