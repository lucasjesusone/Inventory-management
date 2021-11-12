package com.ms.crud.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@NotNull
@NotBlank
public class InvoiceProductDto {

    private Integer productCode;
    private String productDescription;
    private String unit;
    private Double quantity;
    private Double totalValue;
    private Double icmsAliquot;
    private Double unitaryValue;
    private Integer cfop;
    private Integer cst;
    private Integer ncmSh;

}
