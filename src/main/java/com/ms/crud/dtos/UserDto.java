package com.ms.crud.dtos;

import com.ms.crud.enums.EnumStatus;
import com.ms.crud.models.UserModel;
import lombok.Data;
import org.apache.catalina.User;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NotBlank
@NotNull
public class UserDto {


    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @Enumerated(EnumType.STRING)
    private EnumStatus status;

}
