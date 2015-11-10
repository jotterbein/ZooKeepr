package com.catalyst.zookeepr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.zookeepr.entities.Animal;
import com.catalyst.zookeepr.entities.Enclosure;
import com.catalyst.zookeepr.entities.Food;
import com.catalyst.zookeepr.repository.AnimalRepository;
import com.catalyst.zookeepr.repository.EnclosureRepository;
import com.catalyst.zookeepr.repository.FoodRepository;
import com.catalyst.zookeepr.services.AnimalService;
import com.catalyst.zookeepr.services.EnclosureService;
import com.catalyst.zookeepr.services.FoodService;
import com.catalyst.zookeepr.validator.Validator;
import com.fasterxml.jackson.annotation.JsonProperty;

@RestController
public class ZooKeeprController {
 
	@Autowired
	private EnclosureService enclosureService;
	
	@Autowired
	private AnimalService animalService;
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private EnclosureRepository enRepository;
	
	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	private FoodRepository foodRepository;
	
	private Validator validator = new Validator();
	
	
	public void setEnclosureService(EnclosureService enclosureService) {
		this.enclosureService = enclosureService;
	}

	public void setAnimalService(AnimalService animalService) {
		this.animalService = animalService;
	}

	public void setFoodService(FoodService foodService) {
		this.foodService = foodService;
	}
	
	/**
	 * Gets all the enclosures from the database
	 * @return: List of enclosures
	 */
	@RequestMapping(value = "/getEn", method = RequestMethod.GET)
	@ResponseBody
	public List<Enclosure> getEnclosures() {	
		return enclosureService.getEnclosures();
	}
	
	@RequestMapping(value = "/addEn", method = RequestMethod.POST)
	@ResponseBody
	public Enclosure addEnclosure(@RequestBody Enclosure enclosure) {
		validator.validateEnclosure(enclosure);
		return enclosureService.createEnclosure(enclosure);
	}
	
	@RequestMapping(value = "/updateEn", method = RequestMethod.PUT)
	@ResponseBody
	public Enclosure updateEnclosure(@RequestBody Enclosure enclosure) {
		validator.validateEnclosure(enclosure);
		return enclosureService.updateEnclosure(enclosure);
	}
	
	@RequestMapping(value = "/En/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteEnclosure(@PathVariable long id) {
		enclosureService.deleteEnclosure(id);
	}
	
	/**
	 * Gets a list of all foods from the database
	 * @return: List of all foods
	 */
	@RequestMapping(value = "/getFood", method = RequestMethod.GET)
	@ResponseBody
	public List<Food> getFood() {
		return foodService.getFoods();
	}
	
	/**
	 * Adds a food to the database
	 * @param food: Food to be added
	 */
	@RequestMapping(value = "/addFood", method = RequestMethod.POST)
	@ResponseBody
	public void addFood(@RequestBody Food food) {
		validator.validateFood(food);
		foodService.createFood(food);
	}
	
	/**
	 * Updates a food in the database
	 * @param food: Updated version of a food
	 */
	@RequestMapping(value = "/updateFood", method = RequestMethod.PUT)
	@ResponseBody
	public void updateFood(@RequestBody Food food) {
		validator.validateFood(food);
		foodService.updateFood(food);
	}
	
	/**
	 * Gets all animals from the database
	 * @return: List of all animals
	 */
	@RequestMapping(value = "/getAnimals", method = RequestMethod.GET)
	@ResponseBody
	public List<Animal> getAnimals() {
		return animalService.getAnimals();
	}
	
	@RequestMapping(value = "/addAnimal", method = RequestMethod.POST)
	@ResponseBody
	public Animal addAnimal(@RequestBody Animal animal) {
		return animalService.createAnimal(animal);
	}
	
	@RequestMapping(value = "updateAnimal", method = RequestMethod.PUT)
	@ResponseBody
	public Animal updateAnimal(@RequestBody Animal animal) {
		return animalService.updateAnimal(animal);
	}

}
