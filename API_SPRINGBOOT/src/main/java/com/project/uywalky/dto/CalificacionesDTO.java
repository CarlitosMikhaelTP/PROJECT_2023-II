package com.project.uywalky.dto;

import com.project.uywalky.Entity.Paseadores;
import com.project.uywalky.Entity.Paseos;
import com.project.uywalky.Entity.Propietarios;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.sql.Timestamp;

public class CalificacionesDTO {

    private int paseos;
    private int paseadores;
    private int propietarios;
    private Integer calificacion;
    private Integer estado;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Integer createdBy;
    private Integer updatedBy;

    public CalificacionesDTO() {
    }

    public CalificacionesDTO(int paseos, int paseadores, int propietarios, Integer calificacion, Integer estado, Timestamp createdAt, Timestamp updatedAt, Integer createdBy, Integer updatedBy) {
        this.paseos = paseos;
        this.paseadores = paseadores;
        this.propietarios = propietarios;
        this.calificacion = calificacion;
        this.estado = estado;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public int getPaseos() {
        return paseos;
    }

    public void setPaseos(int paseos) {
        this.paseos = paseos;
    }

    public int getPaseadores() {
        return paseadores;
    }

    public void setPaseadores(int paseadores) {
        this.paseadores = paseadores;
    }

    public int getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(int propietarios) {
        this.propietarios = propietarios;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String toString() {
        return "CalificacionesDTO{" +
                "paseos=" + paseos +
                ", paseadores=" + paseadores +
                ", propietarios=" + propietarios +
                ", calificacion=" + calificacion +
                ", estado=" + estado +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                '}';
    }
}
