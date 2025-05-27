package com.verificacontato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.verificacontato.service.ContatoOficialService;

@RestController
@RequestMapping("/api/contato")
public class ContatoOficialController {

    @Autowired
    private ContatoOficialService service;

    @GetMapping("/verificar")
    public ResponseEntity<String> verificarContato(@RequestParam String numero) {
        boolean existe = service.isContatoOficial(numero);
        return ResponseEntity.ok(existe ? "Número oficial" : "Número não encontrado na base oficial");
    }
}

