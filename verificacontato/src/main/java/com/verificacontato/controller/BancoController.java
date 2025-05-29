package com.verificacontato.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.verificacontato.dto.NumeroOficialDTO;
import com.verificacontato.service.BancoService;

@RestController
@RequestMapping("/api/bancos")
public class BancoController {

    @Autowired
    private BancoService bancoService;

@GetMapping("/{codigo}/numeros")
    public ResponseEntity<List<NumeroOficialDTO>> getNumerosPorCodigo(@PathVariable String codigo) {
    List<NumeroOficialDTO> numeros = bancoService.buscarNumerosPorCodigoBanco(codigo);
    return ResponseEntity.ok(numeros);
}


    @GetMapping("/numeros")
    public ResponseEntity<List<NumeroOficialDTO>> getNumerosPorNome(@RequestParam String nome) {
        List<NumeroOficialDTO> numeros = bancoService.buscarNumerosPorNomeBanco(nome);
        return ResponseEntity.ok(numeros);
    }
}

