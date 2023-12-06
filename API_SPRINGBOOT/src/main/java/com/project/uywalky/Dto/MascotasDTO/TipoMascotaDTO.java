package com.project.uywalky.Dto.MascotasDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.uywalky.Entity.MascotasEntitys.TipoMascota;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoMascotaDTO {

    @JsonProperty("id_tipo_mascota")
    private int id;
    private String nombre;
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

    public TipoMascotaDTO(TipoMascota tipoMascota){
        this.id = tipoMascota.getIdTipoMascota();
        this.nombre = tipoMascota.getNombre();
    }

}
