package com.codingdojo.products.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.products.models.Product;
import com.codingdojo.products.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("")
	public String products(Model model) {
		ArrayList<Product> products = productService.all();
		model.addAttribute("asdasdasd",products);
		return "index";
	}
}
