package com.project.uywalky.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.uywalky.Entity.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaseosDTO {

   @JsonProperty("idPaseo")
    private int id;
    private Integer reservaId;
    private String comentario;
    private String calificacion;
    private Integer costo;
    private String fecha_paseo;
    private String hora_paseo;
    private String duracion_real;
    private String lugar;
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

    public PaseosDTO(Paseos paseos){
        this.id = paseos.getIdPaseo();
        this.reservaId = paseos.getReservas().getIdReserva();
        this.comentario = paseos.getComentario();
        this.calificacion = paseos.getCalificacion();
        this.costo = paseos.getCosto();
        this.fecha_paseo = paseos.getFecha_paseo();
        this.hora_paseo = paseos.getHora_paseo();
        this.duracion_real = paseos.getDuracion_real();
        this.lugar = paseos.getLugar();
    }

}
