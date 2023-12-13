package com.example.demo.infrastructure.web.projection.UsuarioProjections.interfaceBased.closed;

import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.sql.Timestamp;

public interface PaseoProjection {

    // Información que ve el usuario
    Integer getIdPaseo();

    @Value("#{target.Reservas.idReserva}")
    Integer getIdReserva();

    Timestamp fechaPaseo();

    BigDecimal costo();
}
