package com.codingdojo.products.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.codingdojo.products.models.Category;
import com.codingdojo.products.repositories.CategoryRepository;

@Service
public class CategoryService {
	private CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public ArrayList<Category> all(){
		return (ArrayList<Category>) categoryRepository.findAll();
	}
	
	public Category findOne(Long id) {
		return categoryRepository.findById(id).get();
	}
	
	public void create(Category category){
		categoryRepository.save(category);
	}
	
	public void destroy(Long id){
		categoryRepository.deleteById(id);
	}
	
	public void update(Category category){
		categoryRepository.save(category);
	}
}
