package com.project.uywalky.Dto.PropietariosDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.uywalky.Entity.PropietariosEntitys.LocacionPropietario;
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
    private Integer usuarioId;
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
        this.usuarioId = locacionPropietario.getUser().getId();
        this.latitud = locacionPropietario.getLatitud();
        this.longitud = locacionPropietario.getLongitud();
    }
}
