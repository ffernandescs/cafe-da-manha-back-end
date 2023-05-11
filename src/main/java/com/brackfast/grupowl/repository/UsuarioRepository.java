package com.brackfast.grupowl.repository;

import com.brackfast.grupowl.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
	
	@Modifying
    @Transactional
	@Query(value = "INSERT INTO usuario (nome, login, password) VALUES (:nome, :login, :password)",nativeQuery = true)
	void createUsuario(@Param("nome") String nome, @Param("login") String login, @Param("password") String password);

	public Optional<UsuarioModel> findByLogin(String login);

}
