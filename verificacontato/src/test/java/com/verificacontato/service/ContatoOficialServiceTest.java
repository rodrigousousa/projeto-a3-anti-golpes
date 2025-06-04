package com.verificacontato.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Optional;

import com.verificacontato.dto.ContatoOficialDTO;
import com.verificacontato.model.Banco;
import com.verificacontato.model.ContatoOficial;
import com.verificacontato.repository.ContatoOficialRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ContatoOficialServiceTest {

    @Mock
    private ContatoOficialRepository repository;

    @InjectMocks
    private ContatoOficialService service;

    @Test
    public void buscarDadosDoContato_DeveRetornarDTO_QuandoNumeroExiste() {
        // Arrange
        String numero = "123456789";
        Banco banco = new Banco();
        banco.setNome("Banco Teste");

        ContatoOficial contato = new ContatoOficial();
        contato.setNumeroTelefone(numero);
        contato.setBanco(banco);
        contato.setDataCadastro(LocalDateTime.of(2023, 10, 1, 12, 0));

        when(repository.findByNumeroTelefone(numero)).thenReturn(Optional.of(contato));

        // Act
        Optional<ContatoOficialDTO> resultado = service.buscarDadosDoContato(numero);

        // Assert
        assertTrue(resultado.isPresent(), "DTO não foi retornado");
        assertEquals("Banco Teste", resultado.get().getNomeBanco());
        assertEquals(LocalDateTime.of(2023, 10, 1, 12, 0), resultado.get().getDataCadastro());
    }

    @Test
public void buscarDadosDoContato_DeveRetornarVazio_QuandoNumeroNaoExiste() {
    // Arrange
    String numeroInexistente = "999999999";
    when(repository.findByNumeroTelefone(numeroInexistente)).thenReturn(Optional.empty());

    // Act
    Optional<ContatoOficialDTO> resultado = service.buscarDadosDoContato(numeroInexistente);

    // Assert
    assertFalse(resultado.isPresent(), "Resultado deveria estar vazio quando número não existe");
}

}


