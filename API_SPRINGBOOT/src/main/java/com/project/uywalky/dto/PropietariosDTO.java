package com.project.uywalky.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.uywalky.Entity.Mascotas;
import com.project.uywalky.Entity.Propietarios;
import com.project.uywalky.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropietariosDTO {

    @JsonProperty("id_propietario")
    private int id; // Id de la tabla de propietarios
    private int userId; // Id de la tabla usuarios
    private int id_mascota; // Id de la tabla de mascotas
    private Integer calificacion;
    private String comentario;
    private String preferencias_paseo;
    private Integer saldo;
    private Integer disponibilidad;
    private String foto;
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

    public PropietariosDTO(Propietarios propietarios) {
        this.id = propietarios.getId_propietario();
        this.userId = propietarios.getUser().getId();
        this.id_mascota = propietarios.getMascotas().getIdMascota();
        this.calificacion = propietarios.getCalificacion();
        this.comentario = propietarios.getComentario();
        this.preferencias_paseo = propietarios.getPreferencias_paseo();
        this.saldo = propietarios.getSaldo();
        this.disponibilidad = propietarios.getDisponibilidad();
        this.foto = propietarios.getFoto();
    }
}
