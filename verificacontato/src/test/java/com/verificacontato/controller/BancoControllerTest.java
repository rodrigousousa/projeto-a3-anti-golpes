package com.verificacontato.controller;

import com.verificacontato.dto.NumeroOficialDTO;
import com.verificacontato.service.BancoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BancoController.class)
@AutoConfigureMockMvc(addFilters = false) // desativa filtros de segurança
public class BancoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BancoService bancoService;

    @Test
    @DisplayName("GET /api/bancos/001/numeros - deve retornar números por código")
    void getNumerosPorCodigo_DeveRetornarNumeros() throws Exception {
        String codigoBanco = "001";
        List<NumeroOficialDTO> mockNumeros = List.of(
                new NumeroOficialDTO("111111111", LocalDateTime.now()),
                new NumeroOficialDTO("222222222", LocalDateTime.now())
        );

        when(bancoService.buscarNumerosPorCodigoBanco(codigoBanco)).thenReturn(mockNumeros);

        mockMvc.perform(get("/api/bancos/{codigo}/numeros", codigoBanco)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(mockNumeros.size()))
                .andExpect(jsonPath("$[0].numeroTelefone").value("111111111"));
    }

    @Test
    @DisplayName("GET /api/bancos/numeros?nome=BancoX - deve retornar números por nome")
    void getNumerosPorNome_DeveRetornarNumeros() throws Exception {
        String nomeBanco = "BancoX";
        List<NumeroOficialDTO> mockNumeros = List.of(
                new NumeroOficialDTO("333333333", LocalDateTime.now())
        );

        when(bancoService.buscarNumerosPorNomeBanco(nomeBanco)).thenReturn(mockNumeros);

        mockMvc.perform(get("/api/bancos/numeros")
                        .param("nome", nomeBanco)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(mockNumeros.size()))
                .andExpect(jsonPath("$[0].numeroTelefone").value("333333333"));
    }
}

