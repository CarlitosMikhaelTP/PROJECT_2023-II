package com.project.uywalky.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.uywalky.Entity.MascotasPropietarios;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mascotas_PropietariosDTO {

    @JsonProperty("id_mascota_propietario")
    private int id;
    private Integer propietariosId; //
    private Integer mascotasId;
    private Integer estado;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Timestamp createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Timestamp updatedAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer createdBy;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer updatedBy;

    public Mascotas_PropietariosDTO(MascotasPropietarios mascotasPropietarios){
        this.id = mascotasPropietarios.getId_mascota_propietario();
        this.propietariosId = mascotasPropietarios.getPropietarios().getId_propietario();
        this.mascotasId = mascotasPropietarios.getMascotas().getId_mascota();
        this.estado = mascotasPropietarios.getEstado();
    }
}
