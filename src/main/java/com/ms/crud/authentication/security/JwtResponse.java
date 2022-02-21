package com.ms.crud.authentication.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private String email;
    private String password;


    public JwtResponse(String token, String email, String password) {
        this.token = token;
        this.email = email;
        this.password = password;
    }

    public JwtResponse(String token) {
        this.token = token;
    }
}