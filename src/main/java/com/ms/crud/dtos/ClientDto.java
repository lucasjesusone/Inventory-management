package com.ms.crud.dtos;

import com.ms.crud.enums.EnumClient;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NotNull
@NotBlank
public class ClientDto {

    private String cnpj;
    private String stateRegistration;
    private String countyRegistration;
    private String corporateName;
    private String address;
    private String neighborhood;
    private String cep;
    private Number phoneNumber;
    private String city;
    private String uf;
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private EnumClient status;

}
