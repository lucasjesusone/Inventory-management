package com.ms.crud.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class ServiceDto {

    @NotBlank
    private String serviceName;
    @NotBlank
    private String description;
    private LocalDateTime createdAt;
}
