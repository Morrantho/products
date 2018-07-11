package com.codingdojo.products.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=1,max=255,message="GIVE YOUR PRODUCT A NAME!!!!!!!!")
	
	private String name;

	@Min(1)	
	private double cost;	
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="categories_products",
		joinColumns=@JoinColumn(name="product_id"),
		inverseJoinColumns=@JoinColumn(name="category_id")
	)
	private List<Category> categories;

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

	public void setCategories(List<Category> categories){
		this.categories = categories;
	}
	public List<Category> getCategories(){
		return categories;
	}
}
