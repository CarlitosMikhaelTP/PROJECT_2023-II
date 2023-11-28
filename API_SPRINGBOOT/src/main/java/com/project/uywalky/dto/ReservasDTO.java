package com.project.uywalky.dto;

import com.project.uywalky.Entity.Mascotas;
import com.project.uywalky.Entity.Paseadores;
import com.project.uywalky.Entity.Propietarios;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.sql.Timestamp;

public class ReservasDTO {

    private int propietarios;
    private int paseadores;
    private int mascotas;
    private Integer costo;
    private String fecha_reserva;
    private String hora_reserva;
    private String punto_encuentro;
    private Integer duracion;
    private String lugar_paseo;
    private Integer estado;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Integer createdBy;
    private Integer updatedBy;

    public ReservasDTO() {
    }

    public ReservasDTO(int propietarios, int paseadores, int mascotas, Integer costo, String fecha_reserva, String hora_reserva, String punto_encuentro, Integer duracion, String lugar_paseo, Integer estado, Timestamp createdAt, Timestamp updatedAt, Integer createdBy, Integer updatedBy) {
        this.propietarios = propietarios;
        this.paseadores = paseadores;
        this.mascotas = mascotas;
        this.costo = costo;
        this.fecha_reserva = fecha_reserva;
        this.hora_reserva = hora_reserva;
        this.punto_encuentro = punto_encuentro;
        this.duracion = duracion;
        this.lugar_paseo = lugar_paseo;
        this.estado = estado;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public int getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(int propietarios) {
        this.propietarios = propietarios;
    }

    public int getPaseadores() {
        return paseadores;
    }

    public void setPaseadores(int paseadores) {
        this.paseadores = paseadores;
    }

    public int getMascotas() {
        return mascotas;
    }

    public void setMascotas(int mascotas) {
        this.mascotas = mascotas;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public String getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(String fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public String getHora_reserva() {
        return hora_reserva;
    }

    public void setHora_reserva(String hora_reserva) {
        this.hora_reserva = hora_reserva;
    }

    public String getPunto_encuentro() {
        return punto_encuentro;
    }

    public void setPunto_encuentro(String punto_encuentro) {
        this.punto_encuentro = punto_encuentro;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getLugar_paseo() {
        return lugar_paseo;
    }

    public void setLugar_paseo(String lugar_paseo) {
        this.lugar_paseo = lugar_paseo;
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
        return "ReservasDTO{" +
                "propietarios=" + propietarios +
                ", paseadores=" + paseadores +
                ", mascotas=" + mascotas +
                ", costo=" + costo +
                ", fecha_reserva='" + fecha_reserva + '\'' +
                ", hora_reserva='" + hora_reserva + '\'' +
                ", punto_encuentro='" + punto_encuentro + '\'' +
                ", duracion=" + duracion +
                ", lugar_paseo='" + lugar_paseo + '\'' +
                ", estado=" + estado +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                '}';
    }
}
