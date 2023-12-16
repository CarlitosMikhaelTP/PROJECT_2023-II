package com.example.demo.infrastructure.web.projection.UsuarioProjections.interfaceBased.closed;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public interface PaseadorProjection {

    Integer getIdPaseador();

    // Anotación para llamar directamente a la propiedad de
    // otro campo de la propiedad de categoría en este caso
    // del nombre
    @Value("#{target.Categorias.categoriaNombre}")
    String getCategoriaNombre();
    Integer getCalificacion();
    String getDescripcion();
    String getExperiencia();
    BigDecimal getTarifa();
    BigDecimal getSaldo();
    Boolean getDisponibilidad();
}
