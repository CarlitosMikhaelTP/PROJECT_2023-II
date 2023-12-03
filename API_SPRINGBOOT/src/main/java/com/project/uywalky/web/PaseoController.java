package com.project.uywalky.web;

import com.project.uywalky.Entity.Paseos;
import com.project.uywalky.Service.PaseoService;
import com.project.uywalky.dto.PaseosDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/paseos")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class PaseoController {

    // Inicializando el servicio de paseo
    private final PaseoService paseoService;

    // ENDPOINT PARA REGISTRAR PASEOS
    @PostMapping("/registrar")
    public ResponseEntity<PaseosDTO> registrarPaseos(@RequestBody PaseosDTO paseosDTO){
        PaseosDTO pasepRegistrado = paseoService.registrarPaseos(paseosDTO);
        return ResponseEntity.ok(pasepRegistrado);
    }

    // ENDPOINT PARA MOSTRAR PASEOS REGISTRADOS
    @GetMapping
    public List<Paseos> listarPaseos(){
        return paseoService.listarPaseos();
    }

    // ENDPOINT PARA MOSTRAR UN PASEO POR ID
    @GetMapping("/{id}")
    public Paseos obtenerPaseos(@PathVariable("id") Integer id_paseo){
        return paseoService.obtenerPaseos(id_paseo);
    }

    // ENDPOINT PARA GUARDAR NUEVOS PASEOS
    @PostMapping
    public ResponseEntity<String> guardarPaseo(@RequestBody Paseos paseos){
        paseoService.guardarPaseo(paseos);
        return ResponseEntity.status(HttpStatus.CREATED).body("Paseo guardado con éxito");
    }

    // ENDPOINT PARA ELIMINAR UN REGISTRO DE PASEO POR SU ID
    @PutMapping("/{id}")
    public ResponseEntity<PaseosDTO> editarPaseos(
            @PathVariable("id") Integer id,
            @RequestBody PaseosDTO paseosDTO) {
        PaseosDTO paseoEditado = paseoService.editarPaseo(id, paseosDTO);
        return ResponseEntity.ok(paseoEditado);
    }
}
