package com.ms.InventoryManagement.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.InventoryManagement.enums.EnumStatus;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name="users")

public class UserModel implements Serializable {
    private static final long serialVersionUid = 1L;

    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "users_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @Enumerated(EnumType.STRING)
    private EnumStatus status;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserModel userModel = (UserModel) o;

        return Objects.equals(id, userModel.id);
    }

    @Override
    public int hashCode() {
        return 484641579;
    }
}
