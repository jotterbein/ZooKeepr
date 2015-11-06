package com.catalyst.zookeepr.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "animal", catalog = "zookeepr")
public class Animal implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "animalid", unique = true)
	private long id;
	
	@Size(max = 64)
	@Column(name = "name")
	private String name;
	
	@Size(max = 64)
	@Column(name = "scientific_name")
	private String scienceName;
	
	@Column(name = "food")
	private long food;
	
	@Size(max = 200)
	@Column(name = "url")
	private String url;

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

	public String getScienceName() {
		return scienceName;
	}

	public void setScienceName(String scienceName) {
		this.scienceName = scienceName;
	}

	public long getFood() {
		return food;
	}

	public void setFood(long food) {
		this.food = food;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
