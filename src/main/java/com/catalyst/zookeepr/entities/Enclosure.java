package com.catalyst.zookeepr.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "enclosure", catalog = "zookeepr")
public class Enclosure implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private long id;
	
	@Size(max = 64)
	@Column(name = "name")
	private String name;
	
	@Size(max = 64)
	@Column(name = "cond")
	private String condition;
	
	@Column(name = "hour")
	private int hour;
	
	@Column(name = "minute")
	private int minute;
	
	@Column(name = "number")
	private int number;
	
	@Column(name = "animal")
	private long animal;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getHour() {
		return hour;
	}

	public void sethour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public long getAnimal() {
		return animal;
	}

	public void setAnimal(long animal) {
		this.animal = animal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
	