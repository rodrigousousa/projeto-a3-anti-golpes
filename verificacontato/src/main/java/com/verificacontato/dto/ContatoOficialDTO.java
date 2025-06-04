package com.verificacontato.dto;


import java.time.LocalDateTime;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContatoOficialDTO {
    private String nomeBanco;
    private LocalDateTime dataCadastro;
}

