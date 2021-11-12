package com.ms.crud.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NotBlank
@NotNull
public class ServiceDto {

    private String serviceName;
    private String description;
    private LocalDateTime createdAt;
}
