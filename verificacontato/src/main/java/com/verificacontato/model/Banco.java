package com.verificacontato.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bancos") // <-- define explicitamente o nome da tabela
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String codigoBanco;  // Ex: "001", "237", etc.

    private String nome;

     @OneToMany(mappedBy = "banco", cascade = CascadeType.ALL)
    private List<ContatoOficial> contatos;
}

