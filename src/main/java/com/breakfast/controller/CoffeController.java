package com.breakfast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.breakfast.model.Coffe;
import com.breakfast.repository.CoffeRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/coffe")
@AllArgsConstructor
public class CoffeController {
	
	@Autowired
	private final CoffeRepository coffeRepository;
	


	@GetMapping
	public List<Coffe> list() {
		return coffeRepository.findAll();
	} 
	
	

}
