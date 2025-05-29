package com.verificacontato.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verificacontato.model.ContatoOficial;
import java.util.List;


@Repository
public interface ContatoOficialRepository extends JpaRepository<ContatoOficial, Long> {
    Optional<ContatoOficial> findByNumeroTelefone(String numeroTelefone);
    //List<ContatoOficial> findByBanco_Id(Long bancoId);
    List<ContatoOficial> findByBancoNomeIgnoreCase(String nomeBanco);
    List<ContatoOficial> findByBancoCodigoBanco(String codigoBanco);
}


