package com.project.uywalky.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.uywalky.Entity.Categorias;
import com.project.uywalky.Entity.Paseadores;
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
        this.id = paseadores.getId_paseador();
        this.userId = paseadores.getUser().getId();
        this.id_categoria = paseadores.getCategorias().getId_categoria();
        this.calificacion = paseadores.getCalificacion();
        this.descripcion = paseadores.getDescripcion();
        this.experiencia = paseadores.getDescripcion();
        this.ubicacion = paseadores.getUbicacion();
        this.tarifa = paseadores.getTarifa();
        this.saldo = paseadores.getSaldo();
        this.disponibilidad = paseadores.getDisponibilidad();
        this.foto = paseadores.getFoto();
    }

}
