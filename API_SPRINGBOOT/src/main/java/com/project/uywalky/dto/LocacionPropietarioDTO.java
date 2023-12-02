package com.project.uywalky.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.uywalky.Entity.LocacionPropietario;
import com.project.uywalky.Entity.Propietarios;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocacionPropietarioDTO {

    @JsonProperty("id_locacion_propietario")
    private int id;
    private Integer propietariosId;
    private BigDecimal latitud;
    private BigDecimal longitud;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer estado;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Timestamp createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Timestamp updatedAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer createdBy;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer updatedBy;

    public LocacionPropietarioDTO(LocacionPropietario locacionPropietario){
        this.id = locacionPropietario.getId_locacion_propietario();
        this.propietariosId = locacionPropietario.getPropietarios().getId_propietario();
        this.latitud = locacionPropietario.getLatitud();
        this.longitud = locacionPropietario.getLongitud();
    }
}
