package com.example.demo.infrastructure.web.projection.UsuarioProjections.interfaceBased.closed;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
@JsonInclude(JsonInclude.Include.NON_NULL)

public interface PropietarioProjection {

    Integer getIdPropietario();
    Integer getCalificacion();
    String getComentario();
    String getPreferenciasPaseo();
    BigDecimal getSaldo();
    Boolean getDisponibilidad();
    String getUbicacion();
}
