package com.project.uywalky.Dto.PropietariosDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.uywalky.Entity.PropietariosEntitys.Propietarios;
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
    private Integer userId; // Id de la tabla usuarios
    private Integer id_mascota; // Id de la tabla de mascotas
    private Integer calificacion;
    private String comentario;
    private String preferencias_paseo;
    private Integer saldo;
    private Integer disponibilidad;
    private Integer ubicacion;
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
        this.id_mascota = propietarios.getMascotas().getId_mascota();
        this.calificacion = propietarios.getCalificacion();
        this.comentario = propietarios.getComentario();
        this.preferencias_paseo = propietarios.getPreferencias_paseo();
        this.saldo = propietarios.getSaldo();
        this.disponibilidad = propietarios.getDisponibilidad();
        this.ubicacion = propietarios.getUbicacion();
        this.foto = propietarios.getFoto();
    }
}
