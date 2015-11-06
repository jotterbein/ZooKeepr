package com.catalyst.zookeepr.service.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.catalyst.zookeepr.entities.Food;
import com.catalyst.zookeepr.entities.Enclosure;
import com.catalyst.zookeepr.repository.FoodRepository;
import com.catalyst.zookeepr.repository.EnclosureRepository;

public class FoodServiceImplTest {

	FoodRepository repository;
	
	FoodServiceImpl target;
	
	@Before
	public void setUp() {
		target = new FoodServiceImpl();
		repository = Mockito.mock(FoodRepository.class);
		target.setFoodRepository(repository);
	}
	
	@Test
	public void testGetfoods() {
		target.getFoods();
		Mockito.verify(repository).findAll();
	}
	
	@Test
	public void testCreatefoods() {
		Food an = new Food();
		target.createFood(an);
		Mockito.verify(repository).save(an);
	}
	
	@Test
	public void testUpdatefood() {
		Food an = new Food();
		target.updateFood(an);
		Mockito.verify(repository).save(an);
	}
	
	@Test
	public void testGetfoodById() {
		long id = (long) 1.0;
		target.getFoodByID(id);
		Mockito.verify(repository).findOne(id);
	}
	

}