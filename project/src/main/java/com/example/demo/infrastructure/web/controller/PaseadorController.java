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

    // Creacón de los ENDPOINTS
    // ENDPOINT PARA REGISTRAR NUEVOS PASEADORES
    @PostMapping("/register")
    public ResponseEntity<PaseadoresDTO> registrarPaseador(
            @RequestBody PaseadoresDTO paseadoresDTO,
            @RequestParam(value = "foto", required = false) MultipartFile foto
    ) {
        try {
            PaseadoresDTO nuevoPaseador = paseadorService.registrarPaseadores(paseadoresDTO, foto);
            return new ResponseEntity<>(nuevoPaseador, HttpStatus.CREATED);
        } catch (UserNotFoundException | CategoriaNotFoundException | PaseadorExistenteException e) {
            // Manejar excepciones específicas
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (FileProcessingException e) {
            // Manejar excepción relacionada con el procesamiento del archivo
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    // ENDPOINT PARA MOSTRAR UN REGISTRO DE PASEADOR

}
