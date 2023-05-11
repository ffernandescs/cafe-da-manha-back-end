package com.brackfast.grupowl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="coffe")

public class CoffeModel {
	
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String item;

    private String nome;
    
    private String data;

    @CreationTimestamp
    private LocalDateTime dateCreate;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioModel usuario;
    
    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
    
}
