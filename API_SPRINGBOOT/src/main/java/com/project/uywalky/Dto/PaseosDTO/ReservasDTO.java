package com.project.uywalky.Dto.PaseosDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.uywalky.Entity.PaseosEntitys.Reservas;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data // creacion de Get y set tO sTRING
@AllArgsConstructor // Genera un constructor con todos los campos de la entidad
@NoArgsConstructor // Genera un constructor vacío
public class ReservasDTO {
    @JsonProperty("id_reserva")
    private int id;
    private Integer propietarioId;
    private Integer paseadorId;
    private Integer costo;
    private String fecha_reserva;
    private String hora_reserva;
    private String punto_encuentro;
    private Integer duracion;
    private String lugar_paseo;
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

    public ReservasDTO(Reservas reservas){
        this.id= reservas.getIdReserva();
        this.propietarioId = reservas.getPropietarios().getId_propietario();
        this.paseadorId = reservas.getPaseadores().getId_paseador();
        this.fecha_reserva =reservas.getFecha_reserva();
        this.hora_reserva = reservas.getHora_reserva();
        this.punto_encuentro = reservas.getPunto_encuentro();
        this.duracion = reservas.getDuracion();
        this.lugar_paseo = reservas.getLugar_paseo();
    }
}
