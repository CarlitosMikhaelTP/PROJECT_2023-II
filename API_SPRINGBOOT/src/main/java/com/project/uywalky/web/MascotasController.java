package com.project.uywalky.web;

import com.project.uywalky.Entity.Mascotas;
import com.project.uywalky.Service.MascotasService;
import com.project.uywalky.dto.MascotasDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mascotas")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class MascotasController {

    // Importando el servicio de mascotas
    private final MascotasService mascotasService;

    //Creación de ENDPOINT para registrar mascotas
    @PostMapping("/registrar")
    public ResponseEntity<MascotasDTO> registrarMascotas(@RequestBody MascotasDTO mascotasDTO){
        MascotasDTO mascotaRegistrada = mascotasService.registarMascotas(mascotasDTO);
        return ResponseEntity.ok(mascotaRegistrada);
    }

    // Creación de ENDPOINT para mostrar las mascotas registradas
    @GetMapping
    public List<Mascotas> listarMascotas(){
        return mascotasService.listarMascotas();
    }

    // Creación de ENDPOINT para mostrar una mascota por su ID
    @GetMapping("/{id}")
    public Mascotas obtenerMascotas(@PathVariable("id") Integer id_mascota){
        return mascotasService.obtenerMascotas(id_mascota);
    }

    // Creación de ENDPOINT para guardar nuevas mascotas
    @PostMapping
    public ResponseEntity<String> guardarMascotas(@RequestBody Mascotas mascotas){
        mascotasService.guardarMascota(mascotas);
        return ResponseEntity.status(HttpStatus.CREATED).body("Mascota guardada correctamente");
    }

    // Creación de ENDPOINT para eliminar un registro de mascota por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarMascota(@PathVariable("id") Integer id_mascota){
        mascotasService.eliminarMascota(id_mascota);
        return ResponseEntity.status(HttpStatus.OK).body("Mascota eliminada correctamente");
    }

    // Creación de ENDPOINT para editar una mascota por su ID
    @PutMapping("/{id}")
    public ResponseEntity<MascotasDTO> editarMascota(
            @PathVariable("id") Integer id,
            @RequestBody MascotasDTO mascotasDTO){

        MascotasDTO mascotaEditada = mascotasService.editarMascota(id, mascotasDTO);
        return ResponseEntity.ok(mascotaEditada);
    }
}
