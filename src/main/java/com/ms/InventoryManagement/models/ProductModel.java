package com.ms.InventoryManagement.models;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "stock")
public class ProductModel implements Serializable {
    private static final long serialVersionUid = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @NotNull
    private Integer productCode;
    @NotNull
    private String productDescription;
    @NotNull
    private String category;
    @NotNull
    private Double quantity;
    @NotNull
    private Double unitaryValue;
    private Date acquiredDate;
    private Double acquiredValue;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductModel that = (ProductModel) o;

        return Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return 1722830076;
    }
}
