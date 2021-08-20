package com.ms.crud.dtos;

import com.ms.crud.enums.EnumStatus;
import com.ms.crud.models.UserModel;
import lombok.Data;
import org.apache.catalina.User;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @Enumerated(EnumType.STRING)
    private EnumStatus status;

}
