package com.verificacontato.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data                 // gera getters, setters, toString, equals, hashCode
@NoArgsConstructor    // gera construtor sem argumentos
@AllArgsConstructor   // gera construtor com todos os argumentos
public class ContatoOficial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeBanco;
    private String numeroTelefone;
}
