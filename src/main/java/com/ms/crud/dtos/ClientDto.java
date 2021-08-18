package com.ms.crud.dtos;

import com.ms.crud.enums.EnumClient;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class ClientDto {

    @NotBlank
    private String cnpj;
    @NotNull
    private String inscricaoEstadual;
    private String inscricaoMunicipal;
    @NotBlank
    private String razaoSocial;
    @NotNull
    private String endereco;
    @NotNull
    private String bairro;
    @NotBlank
    private String uf;
    @NotNull
    private String cep;
    private String telefone;
    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
    @NotBlank
    private String cidade;
    @Enumerated(EnumType.STRING)
    private EnumClient status;


}
