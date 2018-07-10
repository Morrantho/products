package com.codingdojo.products.controllers;

import java.util.ArrayList;

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
		model.addAttribute("product", new Product());
		
		ArrayList<Product> products = productService.all();
		model.addAttribute("products",products);
		return "index";
	}
	
	@GetMapping("/{id}")
	public String findOne(Model model,@PathVariable("id") Long id ) {
		model.addAttribute("product",productService.findOne(id));
		return "show";
	}
		
	@PostMapping("/{id}")
	public String destroy(@PathVariable("id") Long id) {
		productService.destroy(id);
		return "redirect:/products";
	}
	
	@PostMapping("")
	public String create(@Valid @ModelAttribute("product") Product product, BindingResult res ){
		if(res.hasErrors()) {
			return "index";
		}
		
		productService.create(product);
		return "redirect:/products";
	}
	
	@PostMapping("/{id}/update")
	public String update(@Valid @ModelAttribute("product") Product product, BindingResult res) {
		if(res.hasErrors()) {
			return "show";
		}
		productService.update(product);
		return "redirect:/products/"+product.getId();
	}
}
