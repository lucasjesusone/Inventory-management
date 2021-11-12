package com.ms.crud.models;


import com.ms.crud.enums.EnumClient;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
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
    private Long id;
    private String cnpj;
    private String stateRegistration;
    private String countyRegistration;
    private String corporateName;
    private String address;
    private String neighborhood;
    private String cep;
    private Number phoneNumber;
    private String city;
    private String uf;
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private EnumClient status;

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
