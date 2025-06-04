package com.verificacontato.controller;

import com.verificacontato.dto.ContatoOficialDTO;
import com.verificacontato.service.ContatoOficialService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ContatoOficialController.class)
@AutoConfigureMockMvc(addFilters = false) // desativa filtros de segurança
class ContatoOficialControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContatoOficialService service;

    @Test
    void deveRetornarContatoQuandoNumeroForEncontrado() throws Exception {
        String numero = "11999998888";
        ContatoOficialDTO dto = new ContatoOficialDTO("Banco Teste", LocalDateTime.now());

        when(service.buscarDadosDoContato(numero)).thenReturn(Optional.of(dto));

        mockMvc.perform(get("/api/contato/verificar")
                .param("numero", numero))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.nomeBanco").value("Banco Teste"));
    }

    @Test
    void deveRetornar404QuandoNumeroNaoForEncontrado() throws Exception {
        String numero = "0000000000";

        when(service.buscarDadosDoContato(numero)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/contato/verificar")
                .param("numero", numero))
            .andExpect(status().isNotFound())
            .andExpect(content().string("Número não encontrado na base oficial"));
    }
}

