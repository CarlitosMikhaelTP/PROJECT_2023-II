package com.project.uywalky.dto;

import com.project.uywalky.Entity.EstadoTransaccion;
import com.project.uywalky.Entity.Paseadores;
import com.project.uywalky.Entity.Propietarios;
import com.project.uywalky.Entity.TiposTransaccion;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.sql.Timestamp;

public class TransaccionesDTO {
    private int paseadores;
    private int propietarios;
    private int tiposTransaccion;
    private int estadoTransaccion;
    private Integer monto;
    private Integer estado;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Integer createdBy;
    private Integer updatedBy;

    public TransaccionesDTO() {
    }

    public TransaccionesDTO(int paseadores, int propietarios, int tiposTransaccion, int estadoTransaccion, Integer monto, Integer estado, Timestamp createdAt, Timestamp updatedAt, Integer createdBy, Integer updatedBy) {
        this.paseadores = paseadores;
        this.propietarios = propietarios;
        this.tiposTransaccion = tiposTransaccion;
        this.estadoTransaccion = estadoTransaccion;
        this.monto = monto;
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

    public int getTiposTransaccion() {
        return tiposTransaccion;
    }

    public void setTiposTransaccion(int tiposTransaccion) {
        this.tiposTransaccion = tiposTransaccion;
    }

    public int getEstadoTransaccion() {
        return estadoTransaccion;
    }

    public void setEstadoTransaccion(int estadoTransaccion) {
        this.estadoTransaccion = estadoTransaccion;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
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
        return "TransaccionesDTO{" +
                "paseadores=" + paseadores +
                ", propietarios=" + propietarios +
                ", tiposTransaccion=" + tiposTransaccion +
                ", estadoTransaccion=" + estadoTransaccion +
                ", monto=" + monto +
                ", estado=" + estado +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                '}';
    }
}
