package com.catalyst.zookeepr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catalyst.zookeepr.entities.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long>{

}
