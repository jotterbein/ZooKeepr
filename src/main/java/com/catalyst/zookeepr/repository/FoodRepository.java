package com.catalyst.zookeepr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catalyst.zookeepr.entities.Food;

public interface FoodRepository extends JpaRepository<Food, Long>{

}
