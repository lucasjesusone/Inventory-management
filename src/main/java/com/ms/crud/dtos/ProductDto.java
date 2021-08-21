package com.ms.crud.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class ProductDto {


    @NotBlank
    private String product_name;
    private LocalDateTime createdAt;
}
