package com.ms.InventoryManagement.models;


import com.ms.InventoryManagement.enums.EnumClient;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "clients")
public class ClientModel implements Serializable {

    private static final long serialVersionUid = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    private String cnpj;
    private String cpf;
    @NotNull
    private Boolean type;
    private String stateRegistration;
    private String countyRegistration;
    @NotNull
    private String name;
    private String address;
    private String neighborhood;
    private String cep;
    private Number phoneNumber;
    @NotNull
    private String city;
    @NotNull
    private String uf;
    private Timestamp createdAt;
    @Enumerated(EnumType.STRING)
    private EnumClient status;
    private Timestamp updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ClientModel that = (ClientModel) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 826317977;
    }
}
