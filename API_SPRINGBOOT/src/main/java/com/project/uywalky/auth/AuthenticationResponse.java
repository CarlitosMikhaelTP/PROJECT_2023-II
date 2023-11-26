package com.project.uywalky.auth;

import com.project.uywalky.Entity.TipoUsuario;
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
