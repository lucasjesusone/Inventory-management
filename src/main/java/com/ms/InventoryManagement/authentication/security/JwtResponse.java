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
    private String username;
    private String password;


    public JwtResponse(String token, String email,String username, String password) {
        this.token = token;
        this.email = email;
        this.username = username;
        this.password = password;
    }

}