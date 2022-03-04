package com.ms.InventoryManagement.models;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "products")
public class InvoiceProductModel implements Serializable {
    private static final long serialVersionUid = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InvoiceProductModel that = (InvoiceProductModel) o;

        return Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return 1722830076;
    }
}
