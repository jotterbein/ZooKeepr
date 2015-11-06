package com.catalyst.zookeepr.validator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.zookeepr.entities.Animal;
import com.catalyst.zookeepr.entities.Enclosure;
import com.catalyst.zookeepr.entities.Food;

public class ValidatorTest {

	private Validator validator;
	
	@Before
	public void setup() {
		validator = new Validator();
	}
	
	@Test(expected = ValidationException.class)
	public void testValidateEnclosure() {
		Enclosure enclosure = new Enclosure();
		enclosure.setName("");
		validator.validateEnclosure(enclosure);
	}
	
	@Test(expected = ValidationException.class)
	public void testValidateEnclosure1() {
		Enclosure enclosure = new Enclosure();
		enclosure.setName("Name");
		enclosure.setCondition("");
		validator.validateEnclosure(enclosure);
	}
	
	@Test(expected = ValidationException.class)
	public void testValidateEnclosure2() {
		Enclosure enclosure = new Enclosure();
		enclosure.setName("Name");
		enclosure.setCondition("Condition");
		enclosure.sethour(25);
		validator.validateEnclosure(enclosure);
	}
	
	@Test(expected = ValidationException.class)
	public void testValidateEnclosure3() {
		Enclosure enclosure = new Enclosure();
		enclosure.setName("Name");
		enclosure.setCondition("Condition");
		enclosure.sethour(-1);
		validator.validateEnclosure(enclosure);
	}
	
	@Test(expected = ValidationException.class)
	public void testValidateEnclosure4() {
		Enclosure enclosure = new Enclosure();
		enclosure.setName("Name");
		enclosure.setCondition("Condition");
		enclosure.sethour(0);
		enclosure.setMinute(-1);
		validator.validateEnclosure(enclosure);
	}
	@Test(expected = ValidationException.class)
	public void testValidateEnclosure5() {
		Enclosure enclosure = new Enclosure();
		enclosure.setName("Name");
		enclosure.setCondition("Condition");
		enclosure.sethour(0);
		enclosure.setMinute(61);
		validator.validateEnclosure(enclosure);
	}
	
	@Test(expected = ValidationException.class)
	public void testValidateEnclosure6() {
		Enclosure enclosure = new Enclosure();
		enclosure.setName("Name");
		enclosure.setCondition("Condition");
		enclosure.sethour(0);
		enclosure.setMinute(51);
		enclosure.setNumber(0);
		validator.validateEnclosure(enclosure);
	}
	
	@Test(expected = ValidationException.class)
	public void testValidateEnclosure7() {
		Enclosure enclosure = new Enclosure();
		enclosure.setName("Name");
		enclosure.setCondition("Condition");
		enclosure.sethour(0);
		enclosure.setMinute(51);
		enclosure.setNumber(1);
		enclosure.setAnimal(-1);
		validator.validateEnclosure(enclosure);
	}
	
	public void testValidateEnclosure8() {
		boolean expected = true;
		Enclosure enclosure = new Enclosure();
		enclosure.setName("Name");
		enclosure.setCondition("Condition");
		enclosure.sethour(0);
		enclosure.setMinute(51);
		enclosure.setNumber(1);
		enclosure.setAnimal(0);
		boolean got = validator.validateEnclosure(enclosure);
		assertEquals(expected, got);
	}
	
	@Test(expected = ValidationException.class)
	public void testValidateAnimal() {
		Animal animal = new Animal();
		animal.setName("");
		validator.validateAnimal(animal);
	}
	@Test(expected = ValidationException.class)
	public void testValidateAnimal1() {
		Animal animal = new Animal();
		animal.setName("Name");
		animal.setScienceName("");
		validator.validateAnimal(animal);
	}
	
	@Test(expected = ValidationException.class)
	public void testValidateAnimal2() {
		Animal animal = new Animal();
		animal.setName("Name");
		animal.setScienceName("Science");
		animal.setUrl("");
		validator.validateAnimal(animal);
	}
	
	@Test(expected = ValidationException.class)
	public void testValidateAnimal3() {
		Animal animal = new Animal();
		animal.setName("Name");
		animal.setScienceName("Science");
		animal.setUrl("http://");
		animal.setFood(-1);
		validator.validateAnimal(animal);
	}
	
	@Test
	public void testValidateAnimal4() {
		boolean expected = true;
		Animal animal = new Animal();
		animal.setName("Name");
		animal.setScienceName("Science");
		animal.setUrl("http://");
		animal.setFood(1);
		boolean got = validator.validateAnimal(animal);
		assertEquals(expected, got);
	}
	
	@Test(expected = ValidationException.class)
	public void testValidateFood() {
		Food food = new Food();
		food.setName("");
		validator.validateFood(food);
	}
	
	@Test(expected = ValidationException.class)
	public void testValidateFood1() {
		Food food = new Food();
		food.setName("Name");
		food.setVendor("");
		validator.validateFood(food);
	}
	
	@Test(expected = ValidationException.class)
	public void testValidateFood2() {
		Food food = new Food();
		food.setName("Name");
		food.setVendor("Vendor");
		food.setCategory("None");
		validator.validateFood(food);
	}
	
	@Test
	public void testValidateFood3() {
		boolean expected = true;
		Food food = new Food();
		food.setName("Name");
		food.setVendor("Vendor");
		food.setCategory("Fruit");
		boolean got = validator.validateFood(food);
		assertEquals(expected, got);
	}
}
