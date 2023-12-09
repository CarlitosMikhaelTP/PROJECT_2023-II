package com.example.demo.infrastructure.security.configuration.authentication;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String token;
    private Integer IdTipoUsuario; // Agregando el campo tipo de Usuario
}
