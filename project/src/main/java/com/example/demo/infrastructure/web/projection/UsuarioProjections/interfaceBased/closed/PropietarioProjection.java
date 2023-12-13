package com.example.demo.infrastructure.web.projection.UsuarioProjections.interfaceBased.closed;

import java.math.BigDecimal;

public interface PropietarioProjection {

    Integer getIdPropietario();
    Integer getCalificacion();
    String getComentario();
    String getPreferenciasPaseo();
    BigDecimal getSaldo();
    Boolean getDisponibilidad();
    String getUbicacion();
}
