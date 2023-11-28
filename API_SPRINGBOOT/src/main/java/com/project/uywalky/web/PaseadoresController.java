package com.project.uywalky.web;

import com.project.uywalky.Entity.Paseadores;
import com.project.uywalky.Entity.TipoUsuario;
import com.project.uywalky.Service.PaseadoresService;
import com.project.uywalky.auth.AuthenticationResponse;
import com.project.uywalky.auth.RegisterRequest;
import com.project.uywalky.dto.PaseadoresDTO;
import com.project.uywalky.exception.TipoUsuarioNotFoundException;
import com.project.uywalky.repository.CategoriasRepository;
import com.project.uywalky.repository.PaseadoresRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/paseadores")
// Inicializa automaticamente los campos requeridos en la clase del constructor
// Genera un constructor con todos los campos requeridos marcados como final o @NonNull
@RequiredArgsConstructor // Constructor
@CrossOrigin(origins = "http://localhost:3000")
public class PaseadoresController {

    //Inicializamos las clases para trabajar con este constructor con "final"

    private final PaseadoresService paseadoresService;

    // Creación de los ENDPOINTS
    // Endpoint para registrar nuevos paseadores

    @PostMapping("/registrar")
    public ResponseEntity<PaseadoresDTO> registrarPaseadores(@RequestBody PaseadoresDTO paseadoresDTO) {

        PaseadoresDTO paseadoresRegistrado = paseadoresService.registrarPaseadores(paseadoresDTO);
        return ResponseEntity.ok(paseadoresRegistrado);
    }

}
