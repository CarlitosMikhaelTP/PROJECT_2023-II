package com.project.uywalky.web;

import com.project.uywalky.Entity.TipoMascota;
import com.project.uywalky.Service.TipoMascotaService;
import com.project.uywalky.dto.TipoMascotaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tipomascota")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class TipoMascotaController {

    private final TipoMascotaService tipoMascotaService;

    // ENDPOINT  para registrar Tipos de Mascotas
    @PostMapping("/registrar")
    public ResponseEntity<TipoMascotaDTO> registrarTiposMascota(@RequestBody TipoMascotaDTO tipoMascotaDTO){
        TipoMascotaDTO tipoMascotaRegistrado = tipoMascotaService.registrarTipoMascota(tipoMascotaDTO);
        return ResponseEntity.ok(tipoMascotaRegistrado);
    }

    // ENDPOINT para mostrar todos los tipos de mascotas registrados
    @GetMapping
    public List<TipoMascota> listarTiposMascota(){
        return tipoMascotaService.listarTiposMascota();
    }

    // Creación de ENDPOINT para mostrar al tipo de mascota por ID
    @GetMapping("/{id}")
    public TipoMascota obtenerTipoMascota(@PathVariable("id") Integer id_tipo_mascota){
        return tipoMascotaService.obtenerTipoMascota(id_tipo_mascota);
    }

    // Creación de ENDPOINT para guardar nuevos Tipos de Mascotas
    @PostMapping
    public ResponseEntity<String> guardarTipoMascota(@RequestBody TipoMascota tipoMascota){
        tipoMascotaService.guardarTipoMascota(tipoMascota);
        return ResponseEntity.status(HttpStatus.CREATED).body("Tipo de Mascota guardado exitosamente ");
    }

    // Creación de ENDPOINT para eliminar un tipo de masctoa por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTipoMascota(@PathVariable("id") Integer id_tipo_mascota){
        tipoMascotaService.eliminarTipoMascota(id_tipo_mascota);
        return ResponseEntity.status(HttpStatus.OK).body("Tipo de mascota eliminado correctamente");
    }

    // CreacióN de ENDPOINT para editar un tipo de mascota por su ID
    @PutMapping("/{id}")
    public ResponseEntity<TipoMascotaDTO> editarTipoMascota(
            @PathVariable("id") Integer id,
            @RequestBody TipoMascotaDTO tipoMascotaDTO){

            TipoMascotaDTO tipoMascotaEditado = tipoMascotaService.editarTipoMascota(id, tipoMascotaDTO);
            return ResponseEntity.ok(tipoMascotaEditado);
    }
}
