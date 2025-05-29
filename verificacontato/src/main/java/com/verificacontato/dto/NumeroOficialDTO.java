package com.verificacontato.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NumeroOficialDTO {
    private String numeroTelefone;
    private LocalDateTime dataCadastro;
}

