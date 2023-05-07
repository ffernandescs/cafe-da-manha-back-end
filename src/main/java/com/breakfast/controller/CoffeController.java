package com.breakfast.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.breakfast.model.Coffe;
import com.breakfast.repository.CoffeRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/coffes")
@AllArgsConstructor
public class CoffeController {
	
	private final CoffeRepository coffeRepository;
	


	@GetMapping
	public List<Coffe> list() {
		return coffeRepository.findAll();
	} 
	
	

}
