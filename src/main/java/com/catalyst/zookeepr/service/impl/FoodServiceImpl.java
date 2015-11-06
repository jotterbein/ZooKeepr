package com.catalyst.zookeepr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.zookeepr.entities.Food;
import com.catalyst.zookeepr.repository.FoodRepository;
import com.catalyst.zookeepr.services.FoodService;

@Service
public class FoodServiceImpl implements FoodService{

	@Autowired
	private FoodRepository repository;
	
	@Override
	public List<Food> getFoods() {
		return repository.findAll();
	}

	@Override
	public void createFood(Food food) {
		repository.save(food);
		
	}

	@Override
	public void updateFood(Food food) {
		repository.save(food);
	}

	@Override
	public Food getFoodByID(long id) {
		return repository.findOne(id);
	}

	public void setFoodRepository(FoodRepository repository) {
		this.repository = repository;
		
	}

}
