package com.catalyst.zookeepr.validator;

import com.catalyst.zookeepr.entities.Animal;
import com.catalyst.zookeepr.entities.Enclosure;
import com.catalyst.zookeepr.entities.Food;

public class Validator {

	/**
	 * Checks enclosure to ensure it is not missing anything
	 * @param en: Enclosure being checked
	 * @return: True if everything is in order
	 * @throws ValidationException
	 */
	public boolean validateEnclosure(Enclosure en) throws ValidationException{
		if(en.getName().isEmpty()) {
			throw new ValidationException("Name is Invalid");
		}
		if(en.getCondition().isEmpty()) {
			throw new ValidationException("Condition is Invalid");
		}
		if(en.getHour() <0 || en.getHour() >= 24) {
			throw new ValidationException("Hour is invalid");
		}
		if(en.getMinute() < 0 || en.getMinute() > 60) {
			throw new ValidationException("Minute is invalid");
		}
		if(en.getNumber() <= 0) {
			throw new ValidationException("Invalid number of animals");
		}
		if(en.getAnimal() < 0) {
			throw new ValidationException("Invalid aniaml ID");
		}
		return true;
	}
	
	/**
	 * Checks if animal is valid
	 * @param animal: Animal being checked
	 * @return: true if it is valid
	 * @throws ValidationException
	 */
	public boolean validateAnimal(Animal animal) throws ValidationException {
		if(animal.getName().isEmpty()) {
			throw new ValidationException("Name is invalid");
		}
		if(animal.getScienceName().isEmpty()) {
			throw new ValidationException("Scientific Name is invalid");
		}
		if(!animal.getUrl().startsWith("http://")) {
			throw new ValidationException("Invalid URL");
		}
		if(animal.getFood() <= 0) {
			throw new ValidationException("Invalid Food ID");
		}	
		return true;
	}
	
	/**
	 * Checks if the food is valid
	 * @param food: Food being checked
	 * @return: True if the food is valid
	 * @throws ValidationException
	 */
	public boolean validateFood(Food food) throws ValidationException {
		if(food.getName().isEmpty()) {
			throw new ValidationException("Invalid Name");
		}
		if(food.getVendor().isEmpty()) {
			throw new ValidationException("Invald Vendor");
		}
		if(!food.getCategory().equals("Fruit") && !food.getCategory().equals("Meat") &&
				!food.getCategory().equals("Vegtables") && !food.getCategory().equals("Other")) {
				throw new ValidationException("Category is not one of the options");	
		}
		return true;
	}
	
}
