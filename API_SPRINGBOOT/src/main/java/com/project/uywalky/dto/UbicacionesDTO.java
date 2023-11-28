package com.project.uywalky.dto;

import com.project.uywalky.Entity.Paseadores;
import com.project.uywalky.Entity.Paseos;
import com.project.uywalky.Entity.Propietarios;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.sql.Timestamp;

public class UbicacionesDTO {

    private int paseadores;
    private int propietarios;
    private int paseos;
    private Integer latitud_paseador;
    private Integer longitud_paseador;
    private Integer latitud_propietario;
    private Integer longitud_propietario;
    private String nombre_ubicacion;
    private Integer ubicacion_propietario;
    private Integer ubicacion_paseador;
    private Integer estado;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Integer createdBy;
    private Integer updatedBy;

    public UbicacionesDTO() {
    }

    public UbicacionesDTO(int paseadores, int propietarios, int paseos, Integer latitud_paseador, Integer longitud_paseador, Integer latitud_propietario, Integer longitud_propietario, String nombre_ubicacion, Integer ubicacion_propietario, Integer ubicacion_paseador, Integer estado, Timestamp createdAt, Timestamp updatedAt, Integer createdBy, Integer updatedBy) {
        this.paseadores = paseadores;
        this.propietarios = propietarios;
        this.paseos = paseos;
        this.latitud_paseador = latitud_paseador;
        this.longitud_paseador = longitud_paseador;
        this.latitud_propietario = latitud_propietario;
        this.longitud_propietario = longitud_propietario;
        this.nombre_ubicacion = nombre_ubicacion;
        this.ubicacion_propietario = ubicacion_propietario;
        this.ubicacion_paseador = ubicacion_paseador;
        this.estado = estado;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
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

    public int getPaseos() {
        return paseos;
    }

    public void setPaseos(int paseos) {
        this.paseos = paseos;
    }

    public Integer getLatitud_paseador() {
        return latitud_paseador;
    }

    public void setLatitud_paseador(Integer latitud_paseador) {
        this.latitud_paseador = latitud_paseador;
    }

    public Integer getLongitud_paseador() {
        return longitud_paseador;
    }

    public void setLongitud_paseador(Integer longitud_paseador) {
        this.longitud_paseador = longitud_paseador;
    }

    public Integer getLatitud_propietario() {
        return latitud_propietario;
    }

    public void setLatitud_propietario(Integer latitud_propietario) {
        this.latitud_propietario = latitud_propietario;
    }

    public Integer getLongitud_propietario() {
        return longitud_propietario;
    }

    public void setLongitud_propietario(Integer longitud_propietario) {
        this.longitud_propietario = longitud_propietario;
    }

    public String getNombre_ubicacion() {
        return nombre_ubicacion;
    }

    public void setNombre_ubicacion(String nombre_ubicacion) {
        this.nombre_ubicacion = nombre_ubicacion;
    }

    public Integer getUbicacion_propietario() {
        return ubicacion_propietario;
    }

    public void setUbicacion_propietario(Integer ubicacion_propietario) {
        this.ubicacion_propietario = ubicacion_propietario;
    }

    public Integer getUbicacion_paseador() {
        return ubicacion_paseador;
    }

    public void setUbicacion_paseador(Integer ubicacion_paseador) {
        this.ubicacion_paseador = ubicacion_paseador;
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
        return "UbicacionesDTO{" +
                "paseadores=" + paseadores +
                ", propietarios=" + propietarios +
                ", paseos=" + paseos +
                ", latitud_paseador=" + latitud_paseador +
                ", longitud_paseador=" + longitud_paseador +
                ", latitud_propietario=" + latitud_propietario +
                ", longitud_propietario=" + longitud_propietario +
                ", nombre_ubicacion='" + nombre_ubicacion + '\'' +
                ", ubicacion_propietario=" + ubicacion_propietario +
                ", ubicacion_paseador=" + ubicacion_paseador +
                ", estado=" + estado +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                '}';
    }
}
