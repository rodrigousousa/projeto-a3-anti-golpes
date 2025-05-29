package com.verificacontato.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verificacontato.model.Banco;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Long> {
    Optional<Banco> findByCodigoBanco(String codigoBanco);
    Optional<Banco> findByNome(String nome);
}

