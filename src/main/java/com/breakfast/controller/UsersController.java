package com.breakfast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.breakfast.model.Coffe;
import com.breakfast.model.Register;
import com.breakfast.repository.CoffeRepository;
import com.breakfast.repository.UsersRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {
	
	@Autowired
	private UsersRepository usersRepository;
	


	@GetMapping
	public List<Register> list() {
		return usersRepository.findAll();
	} 
	
	@PostMapping
	public void create(@RequestBody Register register) {
	    usersRepository.saveNativeQuery(register.getCpf(), register.getNome(), register.getPassword());
	}

}
