package com.project.uywalky.Dto.MascotasDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.uywalky.Entity.MascotasEntitys.Mascotas;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MascotasDTO {

    @JsonProperty("id_mascota")
    private int id;
    private Integer tipoMascotaId;
    private String nombre;
    private String raza;
    private String peso;
    private Integer edad;
    private Integer foto;
    private String necesidades;
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

    public MascotasDTO(Mascotas mascotas) {
        this.id = mascotas.getId_mascota();
        this.tipoMascotaId = mascotas.getTipoMascota().getIdTipoMascota();
        this.nombre= mascotas.getNombre();
        this.raza = mascotas.getRaza();
        this.peso = mascotas.getPeso();
        this.edad = mascotas.getEdad();
        this.foto = mascotas.getFoto();
        this.necesidades = mascotas.getNecesidades();
    }
}
