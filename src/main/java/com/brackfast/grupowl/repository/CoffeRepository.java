package com.brackfast.grupowl.repository;

import com.brackfast.grupowl.model.CoffeModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface CoffeRepository extends JpaRepository<CoffeModel, Long> {
	@Modifying
    @Transactional
    @Query(value = "INSERT INTO coffe_model (nome) VALUES (?1)", nativeQuery = true)
    void COffeModel(String item);
    

}
