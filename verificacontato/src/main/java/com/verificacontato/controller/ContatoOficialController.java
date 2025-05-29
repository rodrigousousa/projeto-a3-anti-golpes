package com.verificacontato.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.verificacontato.dto.ContatoOficialDTO;
import com.verificacontato.service.ContatoOficialService;

@RestController
@RequestMapping("/api/contato")
public class ContatoOficialController {

    @Autowired
    private ContatoOficialService service;

    @GetMapping("/verificar")
    public ResponseEntity<?> verificarContato(@RequestParam String numero) {
        Optional<ContatoOficialDTO> contatoOpt = service.buscarDadosDoContato(numero);

        if (contatoOpt.isPresent()) {
            return ResponseEntity.ok(contatoOpt.get()); // Retorna JSON com nomeBanco e dataCadastro
        } else {
            return ResponseEntity.status(404).body("Número não encontrado na base oficial");
        }
    }
}

