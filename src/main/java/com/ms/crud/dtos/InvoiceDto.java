package com.ms.crud.dtos;


import com.ms.crud.enums.TypesUnit;
import com.ms.crud.models.ProductModel;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Data
public class InvoiceDto {

    @NotNull
    private Integer serie;
    @NotNull
    private Integer ncm_sh;
    @NotNull
    private Integer product_code;
    @NotNull
    private Integer invoice_number;
    @NotNull
    private Integer cst;
    private Integer cfop;
    @NotNull
    @Enumerated(EnumType.STRING)
    private TypesUnit unit;
    @NotNull
    private Float value_unit;
    @NotNull
    private Float total_value;
    @NotNull
    private String qtd;
    private LocalDateTime createdAt;
    @OneToOne
    @JoinColumn
    private ProductModel product;
}
