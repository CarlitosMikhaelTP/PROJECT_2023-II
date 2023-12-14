package com.example.demo.infrastructure.web.projection.UsuarioProjections.interfaceBased.closed;

import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.sql.Timestamp;

public interface CalificacionesComentariosProjection {

    // Se mostrará esta información al mostrar 1 ID o TODOS
    Integer getIdCalificacioncomentario();

    @Value("#{target.Paseos.IdPaseo}")
    Integer getIdPaseo();

    @Value("#{target.Paseos.fechaPaseo}")
    Timestamp getFechaPaseo();

    @Value("#{target.Paseos.costo}")
    BigDecimal getCosto();
    String getComentario();
    Integer getCalificacion();

}
