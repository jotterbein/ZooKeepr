package com.catalyst.zookeepr.services;

import java.util.List;

import com.catalyst.zookeepr.entities.Food;

public interface FoodService {

	/**
	 * Gets all the foods in the database
	 * @return: List of all the foods
	 */
	List<Food> getFoods();
	
	/**
	 * Adds a new food to the database
	 * @param food: New food to be added
	 */
	Food createFood(Food food);
	
	/**
	 * Updates a food
	 * @param food: food to be updated
	 */
	Food updateFood(Food food);
	
	Food getFoodByID(long id);
}
