package com.example.demo.infrastructure.web.projection.UsuarioProjections.interfaceBased.closed;

import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

public interface LocacionPropietarioProjection {

    // Proyección para mostrar locaciones de paseadores totales o por ID
    @Value("#{target.Propietarios.User.nombres}")
    String getNombres();

    BigDecimal getLatitud();

    BigDecimal getLongitud();

}
