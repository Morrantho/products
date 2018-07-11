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
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=1,max=255,message="Category Name Required.")
	
	private String name;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="categories_products",
		joinColumns=@JoinColumn(name="category_id"),
		inverseJoinColumns=@JoinColumn(name="product_id")
	)
	private List<Product> products;

	public Category() {
		
	}
	
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}

	public void setProducts(List<Product> products){
		this.products = products;
	}

	public List<Product> getProducts(){
		return products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
