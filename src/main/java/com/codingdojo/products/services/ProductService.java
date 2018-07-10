package com.codingdojo.products.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.codingdojo.products.models.Product;
import com.codingdojo.products.repositories.ProductRepository;

@Service
public class ProductService {
	private ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public ArrayList<Product> all(){
		return (ArrayList<Product>) productRepository.findAll();
	}
}
