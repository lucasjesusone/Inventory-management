package com.ms.InventoryManagement.authentication.security;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private String email;
    private String name;
    private String password;


    public JwtResponse(String token, String email,String name, String password) {
        this.token = token;
        this.email = email;
        this.name = name;
        this.password = password;
    }

}