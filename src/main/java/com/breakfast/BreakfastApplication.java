package com.breakfast;
import com.breakfast.model.Coffe;

import java.sql.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.breakfast.repository.CoffeRepository;


@SpringBootApplication
public class BreakfastApplication {

	public static void main(String[] args) {
		SpringApplication.run(BreakfastApplication.class, args);
	}
	
	@Bean
	CommandLineRunner initDatabase(CoffeRepository coffeRepository) {
		return args -> {
			
			coffeRepository.deleteAll();
			
			Coffe c = new Coffe();
			c.setItem("Bolo");
			c.setUsuario("Felipe Fernandes");
			
			
;
			
			coffeRepository.save(c);
		};
	}

}
