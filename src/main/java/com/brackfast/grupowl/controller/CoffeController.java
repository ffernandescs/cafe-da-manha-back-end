package com.brackfast.grupowl.controller;

import com.brackfast.grupowl.model.CoffeModel;
import com.brackfast.grupowl.model.UsuarioModel;
import com.brackfast.grupowl.repository.CoffeRepository;
import com.brackfast.grupowl.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/coffes")
public class CoffeController {

    private final CoffeRepository coffeRepository;


    public CoffeController(CoffeRepository coffeRepository) {
        this.coffeRepository = coffeRepository;
        
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<CoffeModel>> listarTodos() {
        return ResponseEntity.ok(coffeRepository.findAll());
    }
    
    @PostMapping("/criar")
    public ResponseEntity<CoffeModel> criarCoffeModel(@RequestBody CoffeModel coffeModel) {
        CoffeModel novoCoffeModel = coffeRepository.save(coffeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCoffeModel);
    }

    
}
