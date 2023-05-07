package com.breakfast.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.breakfast.model.Register;

import jakarta.transaction.Transactional;


@Repository
public interface UsersRepository extends JpaRepository<Register, Long> {
	
	@Query(value = "SELECT * FROM users", nativeQuery = true)
	List<Register> findAllNativeQuery();
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO users (cpf, nome, password) VALUES (:cpf, :nome, :password)", nativeQuery = true)
	void saveNativeQuery(final String cpf, final String nome, final String password);

}