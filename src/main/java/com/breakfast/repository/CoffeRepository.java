package com.breakfast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.breakfast.model.Coffe;

@Repository
public interface CoffeRepository extends JpaRepository<Coffe, Long> {
	
}