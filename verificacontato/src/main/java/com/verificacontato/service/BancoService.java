package com.verificacontato.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verificacontato.dto.NumeroOficialDTO;
import com.verificacontato.model.ContatoOficial;
import com.verificacontato.repository.ContatoOficialRepository;

@Service
public class BancoService {

    @Autowired
    private ContatoOficialRepository contatoRepository;

    // public List<NumeroOficialDTO> buscarNumerosPorBancoId(Long id) {
    //     List<ContatoOficial> contatos = contatoRepository.findByBanco_Id(id);
    //     return contatos.stream()
    //             .map(c -> new NumeroOficialDTO(c.getNumeroTelefone(), c.getDataCadastro()))
    //             .collect(Collectors.toList());
    // }
    public List<NumeroOficialDTO> buscarNumerosPorCodigoBanco(String codigoBanco) {
        return contatoRepository.findByBancoCodigoBanco(codigoBanco)
            .stream()
            .map(c -> new NumeroOficialDTO(c.getNumeroTelefone(), c.getDataCadastro()))
            .toList();
}


    public List<NumeroOficialDTO> buscarNumerosPorNomeBanco(String nome) {
        List<ContatoOficial> contatos = contatoRepository.findByBancoNomeIgnoreCase(nome);
        return contatos.stream()
                .map(c -> new NumeroOficialDTO(c.getNumeroTelefone(), c.getDataCadastro()))
                .collect(Collectors.toList());
    }
}

