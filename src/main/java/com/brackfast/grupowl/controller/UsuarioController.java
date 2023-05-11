package com.brackfast.grupowl.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.brackfast.grupowl.model.UsuarioModel;
import com.brackfast.grupowl.security.JWTAutenticarFilter;
import com.brackfast.grupowl.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.HashMap;



@RestController
@RequestMapping("/api")
public class UsuarioController {

    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;
    
    public static final int TOKEN_EXPIRACAO = 600_000;
    public static final String TOKEN_SENHA = "463408a1-54c9-4307-bb1c-6cced559f5a7";
    

    public UsuarioController(UsuarioRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }
    
    

    @GetMapping("/listUsers")
    public ResponseEntity<List<UsuarioModel>> listarTodos() {
        return ResponseEntity.ok(repository.findAll());
    }
    
    @PostMapping("/register")
    public ResponseEntity<UsuarioModel> salvar(@RequestBody UsuarioModel usuario) {
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        usuario.setDataCriacao(LocalDateTime.now());
        UsuarioModel savedUsuario = repository.save(usuario);
        return ResponseEntity.ok(savedUsuario);
    }
 
}
