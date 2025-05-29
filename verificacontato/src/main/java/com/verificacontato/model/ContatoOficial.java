package com.verificacontato.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    private String numeroTelefone;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "banco_id")  // chave estrangeira na tabela contato_oficial
    // private Banco banco;
    @ManyToOne
    @JoinColumn(name = "codigo_banco", referencedColumnName = "codigoBanco")
    private Banco banco;
    
    private LocalDateTime dataCadastro;
}
