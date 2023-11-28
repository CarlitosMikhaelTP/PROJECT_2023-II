package com.project.uywalky.dto;

import com.project.uywalky.Entity.Mascotas;
import com.project.uywalky.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.sql.Timestamp;

public class PropietariosDTO {
    private int user;
    private int mascotas;
    private Integer calificacion;
    private String comentario;
    private String preferencias_paseo;
    private Integer saldo;
    private Boolean disponibilidad;
    private String foto;
    private Integer estado;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Integer createdBy;
    private Integer updatedBy;

    public PropietariosDTO() {
    }

    public PropietariosDTO(int user, int mascotas, Integer calificacion, String comentario, String preferencias_paseo, Integer saldo, Boolean disponibilidad, String foto, Integer estado, Timestamp createdAt, Timestamp updatedAt, Integer createdBy, Integer updatedBy) {
        this.user = user;
        this.mascotas = mascotas;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.preferencias_paseo = preferencias_paseo;
        this.saldo = saldo;
        this.disponibilidad = disponibilidad;
        this.foto = foto;
        this.estado = estado;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getMascotas() {
        return mascotas;
    }

    public void setMascotas(int mascotas) {
        this.mascotas = mascotas;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getPreferencias_paseo() {
        return preferencias_paseo;
    }

    public void setPreferencias_paseo(String preferencias_paseo) {
        this.preferencias_paseo = preferencias_paseo;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
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
        return "PropietariosDTO{" +
                "user=" + user +
                ", mascotas=" + mascotas +
                ", calificacion=" + calificacion +
                ", comentario='" + comentario + '\'' +
                ", preferencias_paseo='" + preferencias_paseo + '\'' +
                ", saldo=" + saldo +
                ", disponibilidad=" + disponibilidad +
                ", foto='" + foto + '\'' +
                ", estado=" + estado +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                '}';
    }
}
