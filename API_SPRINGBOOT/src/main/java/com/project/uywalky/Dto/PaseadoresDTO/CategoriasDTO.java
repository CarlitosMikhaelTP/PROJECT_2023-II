package com.project.uywalky.Dto.PaseadoresDTO;

import java.sql.Timestamp;

public class CategoriasDTO {

    private String categoria_nombre;
    private String descripcion;
    private Integer estado;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Integer createdBy;
    private Integer updatedBy;

    public CategoriasDTO() {
    }

    public CategoriasDTO(String categoria_nombre, String descripcion, Integer estado, Timestamp createdAt, Timestamp updatedAt, Integer createdBy, Integer updatedBy) {
        this.categoria_nombre = categoria_nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public String getCategoria_nombre() {
        return categoria_nombre;
    }

    public void setCategoria_nombre(String categoria_nombre) {
        this.categoria_nombre = categoria_nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        return "CategoriasDTO{" +
                "categoria_nombre='" + categoria_nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                '}';
    }
}
