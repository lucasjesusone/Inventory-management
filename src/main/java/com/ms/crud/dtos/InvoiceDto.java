package com.ms.crud.dtos;


import com.ms.crud.enums.EnumFreight;
import com.ms.crud.enums.TypesUnit;
import com.ms.crud.models.ClientModel;
import com.ms.crud.models.InvoiceModel;
import com.ms.crud.models.ProductModel;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class InvoiceDto {

    @NotNull
    private Integer serie;
    @NotNull
    private Integer ncm_sh;
    @NotNull
    private Integer product_code;
    @NotNull
    private Date issueDate;
    @NotNull
    private String natureOfOperation;
    @NotNull
    private Integer invoice_number;
    @NotNull
    private Integer cst;
    private Integer cfop;
    @NotNull
    @Enumerated(EnumType.STRING)
    private TypesUnit unit;
    @NotNull
    @Enumerated(EnumType.STRING)
    private EnumFreight freight;
    @NotNull
    private Float value_unit;
    @NotNull
    private Float total_value;
    @NotNull
    private Integer qtd;
    private LocalDateTime createdAt;
    @OneToOne
    @JoinColumn
    private ProductModel product;
    @OneToOne
    @JoinColumn
    private ClientModel client;
}
