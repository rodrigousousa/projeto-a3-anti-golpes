package com.verificacontato.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verificacontato.repository.ContatoOficialRepository;

@Service
public class ContatoOficialService {
    @Autowired
    private ContatoOficialRepository repository;

    public boolean isContatoOficial(String numero) {
        return repository.findByNumeroTelefone(numero).isPresent();
    }
}

