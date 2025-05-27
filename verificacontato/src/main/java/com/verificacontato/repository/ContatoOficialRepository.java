package com.verificacontato.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verificacontato.model.ContatoOficial;

@Repository
public interface ContatoOficialRepository extends JpaRepository<ContatoOficial, Long> {
    Optional<ContatoOficial> findByNumeroTelefone(String numeroTelefone);
}

