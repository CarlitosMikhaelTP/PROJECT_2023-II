package com.project.uywalky.Dto.PaseadoresDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.uywalky.Entity.PaseadoresEntitys.LocacionPaseador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocacionPaseadorDTO {
    @JsonProperty("id_locacion_paseador")
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

    public LocacionPaseadorDTO(LocacionPaseador locacionPaseador){
        this.id = locacionPaseador.getId_locacion_paseador();
        this.usuarioId = locacionPaseador.getUser().getId();
        this.latitud = locacionPaseador.getLatitud();
        this.longitud = locacionPaseador.getLongitud();
    }

}
