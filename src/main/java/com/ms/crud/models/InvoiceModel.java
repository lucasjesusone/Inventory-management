package com.ms.crud.models;
import com.ms.crud.enums.EnumFreight;
import com.ms.crud.enums.TypesUnit;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "invoices")
public class InvoiceModel {

    private static final long serialVersionUid = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoice_id;
    private Integer serie;
    private Integer ncm_sh;
    private Integer product_code;
    private Date issueDate;
    private Integer invoice_number;
    private Integer cst;
    private Integer cfop;
    private Integer qtd;
    private String natureOfOperation;
    @Enumerated(EnumType.STRING)
    private TypesUnit unit;
    @Enumerated(EnumType.STRING)
    private EnumFreight freight;
    private Float value_unit;
    private Float total_value;
    private LocalDateTime createdAt;
    @OneToOne
    @JoinColumn
    private ProductModel product;
    @OneToOne
    @JoinColumn
    private ClientModel client;

}
