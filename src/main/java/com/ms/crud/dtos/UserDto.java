package com.ms.crud.dtos;

import com.ms.crud.enums.EnumStatus;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class UserDto {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @Email
    private String username;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
    private LocalDateTime createAt;
    @Enumerated(EnumType.STRING)
    private EnumStatus status;

}
