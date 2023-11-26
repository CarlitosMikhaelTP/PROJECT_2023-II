package com.project.uywalky.dto;

import com.project.uywalky.Entity.TipoUsuario;
import com.project.uywalky.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class NuevoUsuarioDTO {

    private String nombres;

    private String apellidos;

    private int tipoUsuario;

    private String apodo;

    private String direccion;

    private Integer edad;

    private String celular;

    private String dni;

    private String email;

    private String password;

    private Integer estado;

    public NuevoUsuarioDTO() {
    }

    public NuevoUsuarioDTO(String nombres, String apellidos, int tipoUsuario, String apodo, String direccion, Integer edad, String celular, String dni, String email, String password, Integer estado) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoUsuario = tipoUsuario;
        this.apodo = apodo;
        this.direccion = direccion;
        this.edad = edad;
        this.celular = celular;
        this.dni = dni;
        this.email = email;
        this.password = password;
        this.estado = estado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "NuevoUsuarioDTO{" +
                "nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                ", apodo='" + apodo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", edad=" + edad +
                ", celular='" + celular + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", estado=" + estado +
                '}';
    }
}

