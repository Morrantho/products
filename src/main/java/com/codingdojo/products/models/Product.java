package com.codingdojo.products.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min=1,max=255,message="GIVE YOUR PRODUCT A NAME!!!!!!!!")
	
	private String name;

	@Min(1)	
	private double cost;	
	
	public Product() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
}
