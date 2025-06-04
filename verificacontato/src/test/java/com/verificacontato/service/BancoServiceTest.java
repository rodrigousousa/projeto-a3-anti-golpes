package com.verificacontato.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import com.verificacontato.dto.NumeroOficialDTO;
import com.verificacontato.model.Banco;
import com.verificacontato.model.ContatoOficial;
import com.verificacontato.repository.ContatoOficialRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BancoServiceTest {

    @Mock
    private ContatoOficialRepository contatoRepository;

    @InjectMocks
    private BancoService bancoService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void buscarNumerosPorCodigoBanco_RetornaListaDTO_QuandoContatosExistem() {
        // Arrange
        String codigoBanco = "001";
        Banco banco = new Banco();
        banco.setCodigoBanco(codigoBanco);
        banco.setNome("Banco Teste");

        List<ContatoOficial> contatos = new ArrayList<>();
        contatos.add(new ContatoOficial(1L, "123456789", banco, LocalDateTime.of(2023, 5, 10, 10, 0)));
        contatos.add(new ContatoOficial(2L, "987654321", banco, LocalDateTime.of(2023, 5, 11, 11, 0)));

        when(contatoRepository.findByBancoCodigoBanco(codigoBanco)).thenReturn(contatos);

        // Act
        List<NumeroOficialDTO> resultado = bancoService.buscarNumerosPorCodigoBanco(codigoBanco);

        // Assert
        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("123456789", resultado.get(0).getNumeroTelefone());
        assertEquals("987654321", resultado.get(1).getNumeroTelefone());
    }

    @Test
    public void buscarNumerosPorNomeBanco_RetornaListaDTO_QuandoContatosExistem() {
        // Arrange
        String nomeBanco = "Banco Teste";
        Banco banco = new Banco();
        banco.setCodigoBanco("001");
        banco.setNome(nomeBanco);

        List<ContatoOficial> contatos = new ArrayList<>();
        contatos.add(new ContatoOficial(1L, "123456789", banco, LocalDateTime.of(2023, 6, 15, 9, 0)));

        when(contatoRepository.findByBancoNomeIgnoreCase(nomeBanco)).thenReturn(contatos);

        // Act
        List<NumeroOficialDTO> resultado = bancoService.buscarNumerosPorNomeBanco(nomeBanco);

        // Assert
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("123456789", resultado.get(0).getNumeroTelefone());
    }

    @Test
    public void buscarNumerosPorCodigoBanco_RetornaListaVazia_QuandoNaoExistemContatos() {
        // Arrange
        String codigoBanco = "999";
        when(contatoRepository.findByBancoCodigoBanco(codigoBanco)).thenReturn(new ArrayList<>());

        // Act
        List<NumeroOficialDTO> resultado = bancoService.buscarNumerosPorCodigoBanco(codigoBanco);

        // Assert
        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
    }

    @Test
    public void buscarNumerosPorNomeBanco_RetornaListaVazia_QuandoNaoExistemContatos() {
        // Arrange
        String nomeBanco = "Banco Inexistente";
        when(contatoRepository.findByBancoNomeIgnoreCase(nomeBanco)).thenReturn(new ArrayList<>());

        // Act
        List<NumeroOficialDTO> resultado = bancoService.buscarNumerosPorNomeBanco(nomeBanco);

        // Assert
        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
    }
}

