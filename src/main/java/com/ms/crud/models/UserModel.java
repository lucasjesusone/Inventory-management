package com.ms.crud.models;

import com.ms.crud.enums.EnumStatus;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name="users")

public class UserModel implements Serializable {
    private static final long serialVersionUid = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private EnumStatus status;

}
