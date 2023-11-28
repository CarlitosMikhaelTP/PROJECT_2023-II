package com.project.uywalky.dto;

import com.project.uywalky.Entity.Mascotas;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

import java.sql.Timestamp;
import java.util.List;

public class TipoMascotaDTO {
    private String nombre;
    private Integer estado;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Integer createdBy;
    private Integer updatedBy;
    private List<Mascotas> mascotas;

    public TipoMascotaDTO() {
    }

    public TipoMascotaDTO(String nombre, Integer estado, Timestamp createdAt, Timestamp updatedAt, Integer createdBy, Integer updatedBy, List<Mascotas> mascotas) {
        this.nombre = nombre;
        this.estado = estado;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.mascotas = mascotas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public List<Mascotas> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascotas> mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    public String toString() {
        return "TipoMascotaDTO{" +
                "nombre='" + nombre + '\'' +
                ", estado=" + estado +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                ", mascotas=" + mascotas +
                '}';
    }
}
