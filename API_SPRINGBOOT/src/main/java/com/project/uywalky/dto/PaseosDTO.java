package com.project.uywalky.dto;

import com.project.uywalky.Entity.Mascotas;
import com.project.uywalky.Entity.Paseadores;
import com.project.uywalky.Entity.Propietarios;
import com.project.uywalky.Entity.Reservas;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.sql.Timestamp;

public class PaseosDTO {

    private int reservas;
    private int mascotas;
    private int paseadores;
    private int propietarios;
    private String comentario;
    private String calificacion;
    private Integer costo;
    private String fecha_paseo;
    private String hora_paseo;
    private String duracion_real;
    private String lugar;
    private Integer estado;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Integer createdBy;
    private Integer updatedBy;

    public PaseosDTO() {
    }

    public PaseosDTO(int reservas, int mascotas, int paseadores, int propietarios, String comentario, String calificacion, Integer costo, String fecha_paseo, String hora_paseo, String duracion_real, String lugar, Integer estado, Timestamp createdAt, Timestamp updatedAt, Integer createdBy, Integer updatedBy) {
        this.reservas = reservas;
        this.mascotas = mascotas;
        this.paseadores = paseadores;
        this.propietarios = propietarios;
        this.comentario = comentario;
        this.calificacion = calificacion;
        this.costo = costo;
        this.fecha_paseo = fecha_paseo;
        this.hora_paseo = hora_paseo;
        this.duracion_real = duracion_real;
        this.lugar = lugar;
        this.estado = estado;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public int getReservas() {
        return reservas;
    }

    public void setReservas(int reservas) {
        this.reservas = reservas;
    }

    public int getMascotas() {
        return mascotas;
    }

    public void setMascotas(int mascotas) {
        this.mascotas = mascotas;
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public String getFecha_paseo() {
        return fecha_paseo;
    }

    public void setFecha_paseo(String fecha_paseo) {
        this.fecha_paseo = fecha_paseo;
    }

    public String getHora_paseo() {
        return hora_paseo;
    }

    public void setHora_paseo(String hora_paseo) {
        this.hora_paseo = hora_paseo;
    }

    public String getDuracion_real() {
        return duracion_real;
    }

    public void setDuracion_real(String duracion_real) {
        this.duracion_real = duracion_real;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
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
        return "PaseosDTO{" +
                "reservas=" + reservas +
                ", mascotas=" + mascotas +
                ", paseadores=" + paseadores +
                ", propietarios=" + propietarios +
                ", comentario='" + comentario + '\'' +
                ", calificacion='" + calificacion + '\'' +
                ", costo=" + costo +
                ", fecha_paseo='" + fecha_paseo + '\'' +
                ", hora_paseo='" + hora_paseo + '\'' +
                ", duracion_real='" + duracion_real + '\'' +
                ", lugar='" + lugar + '\'' +
                ", estado=" + estado +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                '}';
    }
}
