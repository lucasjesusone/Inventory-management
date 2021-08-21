package com.ms.crud.models;
import com.ms.crud.enums.TypesUnit;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private Integer invoice_number;
    private Integer cst;
    private Integer cfop;
    private Integer qtd;
    @Enumerated(EnumType.STRING)
    private TypesUnit unit;
    private Float value_unit;
    private Float total_value;
    private LocalDateTime createdAt;
    @OneToOne
    @JoinColumn
    private ProductModel product;

}
