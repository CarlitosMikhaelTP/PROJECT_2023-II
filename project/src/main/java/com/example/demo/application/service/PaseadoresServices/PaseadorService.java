package com.example.demo.application.service.PaseadoresServices;


import com.example.demo.infrastructure.web.projection.UsuarioProjections.classBased.PaseadoresDTO;

public interface PaseadorService {

    // DEFINIENDO INTERFAZ para realizar el registro de Paseadores
    PaseadoresDTO registrarPaseador(PaseadoresDTO paseadoresDTO);

    // DEFINIENDO INTERFAZ para realizar la edición de Paseadores
    PaseadoresDTO editarPaseador(Integer id_paseador, PaseadoresDTO paseadoresDTO);
}

