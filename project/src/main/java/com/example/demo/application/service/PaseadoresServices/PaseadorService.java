package com.example.demo.application.service.PaseadoresServices;

import com.example.demo.infrastructure.web.projection.UsuarioProjections.classBased.PaseadoresDTO;
import org.springframework.web.multipart.MultipartFile;

public interface PaseadorService {

    // Para registrar paseadores con su foto
    PaseadoresDTO registrarPaseadores(PaseadoresDTO paseadoresDTO, MultipartFile foto);

}

