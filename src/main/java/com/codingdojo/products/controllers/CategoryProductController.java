package com.codingdojo.products.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.products.models.Product;
import com.codingdojo.products.services.ProductService;
import com.codingdojo.products.models.Category;
import com.codingdojo.products.services.CategoryService;

@Controller
@RequestMapping("/join")
public class CategoryProductController {
	private ProductService productService;
	private CategoryService categoryService;

	public CategoryProductController(ProductService productService,CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}


	@GetMapping("")
	public String show(Model model){
		model.addAttribute("categories",categoryService.all());
		model.addAttribute("products",productService.all());
		return "join";
	}

	@PostMapping("")
	public String join( @RequestParam("productId") Long productId, @RequestParam("categoryId") Long categoryId ){

		Category category = categoryService.findOne(categoryId);
		
		Product product = productService.findOne(productId);
		product.setId(productId);

		// All categories that belong to THIS ONE product.
		List<Category> categories =  product.getCategories();
		categories.add(category);
		product.setCategories(categories);
		productService.update(product);

		return "redirect:/join";
	}
}
