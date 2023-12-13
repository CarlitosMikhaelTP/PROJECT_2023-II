package com.project.uywalky.Security.Authentication;

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
    private Integer IdTipoUsuario;// Agregando el campo tipo de Usuario
    private  Integer Id;
    private String nombres;
    private String apellidos;
}
