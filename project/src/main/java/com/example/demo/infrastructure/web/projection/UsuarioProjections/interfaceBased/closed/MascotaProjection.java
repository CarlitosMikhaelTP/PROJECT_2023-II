package com.example.demo.infrastructure.web.projection.UsuarioProjections.interfaceBased.closed;

import org.springframework.beans.factory.annotation.Value;

public interface MascotaProjection {

    //Campos que se mostrarán
    Integer getIdMascota();
    String getNombre();
    String getRaza();
    String getEdad();
    String getNecesidades();
}
