package com.ms.crud.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name="users")

public class UserModel implements Serializable {
    private static final long serialVersionUID = 3303958233860785745L;

    @Id
    @Column(name = "USER_ID")
    @SequenceGenerator(name = "user_seq", sequenceName = "note_app.user_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private Integer userId;


    @Column(name = "NAME")
    private String name;

    @Column(name = "USERNAME")
    private String username;


    @Column(name = "SECRET")
    private String password;

    @Column(name = "EMAIL")
    private String email;


}
