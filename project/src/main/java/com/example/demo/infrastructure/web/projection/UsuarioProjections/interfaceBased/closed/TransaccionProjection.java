package com.example.demo.infrastructure.web.projection.UsuarioProjections.interfaceBased.closed;

import java.math.BigDecimal;

public interface TransaccionProjection {

    Integer getIdTransaccion();
    BigDecimal getMonto();

}
