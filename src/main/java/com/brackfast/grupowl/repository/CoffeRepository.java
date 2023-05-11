package com.brackfast.grupowl.repository;

import com.brackfast.grupowl.model.CoffeModel;
import com.brackfast.grupowl.model.UsuarioModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface CoffeRepository extends JpaRepository<CoffeModel, Long> {
	
	@Query(value = "SELECT * FROM coffe", nativeQuery = true)
    List<CoffeModel> findAllCoffes();
	
	
	@Query(value = "SELECT * FROM coffe WHERE usuario_id = :idUsuario", nativeQuery = true)
	List<CoffeModel> findAllCoffesByUsuario(@Param("idUsuario") Integer idUsuario);

	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO usuario (item, usuario, data) VALUES (:item, :usuario, :data)", nativeQuery = true)
	void createCoffe(@Param("item") String item, @Param("usuario") String usuario, @Param("data") String data);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM coffe WHERE id = :idCoffe AND usuario_id = :idUsuario", nativeQuery = true)
	int deleteCoffeByUsuario(@Param("idCoffe") Long idCoffe, @Param("idUsuario") Integer idUsuario);


    

}
