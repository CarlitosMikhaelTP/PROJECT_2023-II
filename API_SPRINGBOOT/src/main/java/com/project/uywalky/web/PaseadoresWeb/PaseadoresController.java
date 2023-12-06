package com.project.uywalky.web.PaseadoresWeb;

import com.project.uywalky.Entity.PaseadoresEntitys.Paseadores;
import com.project.uywalky.Service.PaseadoresService;
import com.project.uywalky.Dto.PaseadoresDTO.PaseadoresDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    // Endpoint para registrar nuevos paseadores REALIZADO
    @PostMapping("/registrar")
    public ResponseEntity<PaseadoresDTO> registrarPaseadores(@RequestBody PaseadoresDTO paseadoresDTO) {
        PaseadoresDTO paseadoresRegistrado = paseadoresService.registrarPaseadores(paseadoresDTO);
        return ResponseEntity.ok(paseadoresRegistrado);
    }

    // Creación de ENDPOINT para mostrar los paseadores registrados REALIZADO
    @GetMapping
    public List<Paseadores> listarPaseadores() {
        return paseadoresService.listarPaseadores();
    }

    // Creación de ENDPOINT para mostrar el paseador registrado por su ID REALIZADO
    @GetMapping("/{id}")
    public Paseadores obtenerPaseador(@PathVariable("id") Integer id_paseador) {
        return paseadoresService.obtenerPaseadores(id_paseador);
    }

    // Creación de ENDPOINT para guardar nuevos paseadores REALIZADO
    @PostMapping
    public ResponseEntity<String> guardarPaseador(@RequestBody Paseadores paseadores) {
        paseadoresService.guardarPaseador(paseadores);
        return ResponseEntity.status(HttpStatus.CREATED).body("Paseador guardado exitosamente");
    }

    // Creación de ENDPOINT para eliminar un paseador por su ID REALIZADO
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPaseador(@PathVariable("id") Integer id_paseador) {
        paseadoresService.eliminarPaseador(id_paseador);
        return ResponseEntity.status(HttpStatus.OK).body("Paseador eliminado exitosamente");
    }

    // Creación de ENDPOINT para editar un paseador por su ID REALIZADO
    @PutMapping("/{id}")
    public ResponseEntity<PaseadoresDTO> editarPaseador(
            @PathVariable("id") Integer id,
            @RequestBody PaseadoresDTO paseadoresDTO) {

        PaseadoresDTO paseadorEditado = paseadoresService.editarPaseador(id, paseadoresDTO);
        return ResponseEntity.ok(paseadorEditado);
    }

}
