package com.project.uywalky.Dto.PaseadoresDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.uywalky.Entity.PaseadoresEntitys.Paseadores;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaseadoresDTO {

    private int id;
    private Integer userId; //id del usuario
    private Integer id_categoria;
    private Integer calificacion;
    private String descripcion;
    private String experiencia;
    private Integer ubicacion;
    private Integer tarifa;
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

    public PaseadoresDTO(Paseadores paseadores){
        this.userId = paseadores.getUser().getId();
    }

}
