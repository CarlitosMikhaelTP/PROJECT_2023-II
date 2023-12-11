package com.example.demo.infrastructure.web.controller;

import com.example.demo.application.exceptions.PaseadoresExceptions.Exist.PaseadorExistenteException;
import com.example.demo.application.exceptions.PaseadoresExceptions.NotFound.CategoriaNotFoundException;
import com.example.demo.application.exceptions.PaseadoresExceptions.NotFound.FileProcessingException;
import com.example.demo.application.exceptions.UsuariosExceptions.NotFound.UserNotFoundException;
import com.example.demo.application.service.PaseadoresServices.PaseadorService;
import com.example.demo.domain.entity.paseadores.Paseadores;
import com.example.demo.infrastructure.web.projection.UsuarioProjections.classBased.PaseadoresDTO;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/paseador")
@RequiredArgsConstructor
public class PaseadorController {

    // Inicializamos las clases para trabajar con este constructor con "final"
    private final PaseadorService paseadorService;

    // Endpoint para registrar Paseadores
    @PostMapping("/register")
    public ResponseEntity<PaseadoresDTO> registrarPaseador(@RequestBody PaseadoresDTO paseadoresDTO){
        PaseadoresDTO paseadorRegistrado = paseadorService.registrarPaseador(paseadoresDTO);
        return ResponseEntity.ok(paseadorRegistrado);
    }

    // Endpoint para editar Paseadores
    @PutMapping("/{id}")
    public ResponseEntity<PaseadoresDTO> editarPaseador(
            @PathVariable("id") Integer id,
            @RequestBody PaseadoresDTO paseadoresDTO
    ) {
        PaseadoresDTO paseadorActualizado = paseadorService.editarPaseador(id, paseadoresDTO);
        return ResponseEntity.ok(paseadorActualizado);
    }
}

    // Creacón de los ENDPOINTS
    // ENDPOINT PARA REGISTRAR NUEVOS PASEADORES

