package com.verificacontato.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verificacontato.dto.ContatoOficialDTO;
import com.verificacontato.repository.ContatoOficialRepository;

@Service
public class ContatoOficialService {

    @Autowired
    private ContatoOficialRepository repository;

    public Optional<ContatoOficialDTO> buscarDadosDoContato(String numero) {
        return repository.findByNumeroTelefone(numero)
            .map(contato -> new ContatoOficialDTO(
                contato.getBanco().getNome(),      // pega nome do banco via relacionamento
                contato.getDataCadastro()
            ));
    }
}


