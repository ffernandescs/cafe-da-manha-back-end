package com.brackfast.grupowl.controller;

import com.brackfast.grupowl.model.CoffeModel;
import com.brackfast.grupowl.model.UsuarioModel;
import com.brackfast.grupowl.repository.CoffeRepository;
import com.brackfast.grupowl.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/coffes")
public class CoffeController {

    private final CoffeRepository coffeRepository;
	private UsuarioRepository usuarioRepository;

    @Autowired 
    public CoffeController(CoffeRepository coffeRepository, UsuarioRepository usuarioRepository)  {
        this.coffeRepository = coffeRepository;
        this.usuarioRepository = usuarioRepository;
        
    }
    
    @GetMapping("/listCoffes")
    public ResponseEntity<List<CoffeModel>> listarTodos() {
        List<CoffeModel> coffes = coffeRepository.findAllCoffes();
        return ResponseEntity.ok(coffes);
    }

    
    
    /*@PostMapping("/register")
    public ResponseEntity<CoffeModel> createCoffee(@RequestBody CoffeModel coffe) {
    	CoffeModel savedCafe = coffeRepository.save(coffe);
        return ResponseEntity.ok(savedCafe);
    }*/
    
    
    @PostMapping("/register")
    public ResponseEntity<CoffeModel> createCoffee(@RequestBody CoffeModel coffe, Principal principal) {
        String loggedInUsername = principal.getName();
        Optional<UsuarioModel> optionalUsuario = usuarioRepository.findByLogin(loggedInUsername);
        if (optionalUsuario.isPresent()) {
            UsuarioModel usuario = optionalUsuario.get();
            coffe.setUsuario(usuario);
            CoffeModel savedCafe = coffeRepository.save(coffe);
            return ResponseEntity.ok(savedCafe);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    
    @GetMapping("/listCoffesUser")
    public ResponseEntity<List<CoffeModel>> listarTodos(@RequestParam("idUsuario") Integer idUsuario) {
        List<CoffeModel> coffes = coffeRepository.findAllCoffesByUsuario(idUsuario);
        return ResponseEntity.ok(coffes);
    }
    
}
