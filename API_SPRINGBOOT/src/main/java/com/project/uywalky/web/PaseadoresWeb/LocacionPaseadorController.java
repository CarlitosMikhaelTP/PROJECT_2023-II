package com.project.uywalky.web.PaseadoresWeb;

import com.project.uywalky.Entity.PaseadoresEntitys.LocacionPaseador;
import com.project.uywalky.Service.LocacionPaseadorService;
import com.project.uywalky.Dto.PaseadoresDTO.LocacionPaseadorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/locacionPaseador")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class LocacionPaseadorController {

    // Inicializamos las clases para trabajar con este constructor con "final"
    private final LocacionPaseadorService locacionPaseadorService;

    // ENDPOINT PARA REGISTRAR LA LOCACION DEL PASEADOR
    @PostMapping("/registrar")
    public ResponseEntity<LocacionPaseadorDTO> registrarLocacionPaseador(@RequestBody LocacionPaseadorDTO locacionPaseadorDTO){
        LocacionPaseadorDTO locacionPaseadorRegistrado = locacionPaseadorService.registrarLocacionPaseador(locacionPaseadorDTO);
        return ResponseEntity.ok(locacionPaseadorRegistrado);
    }

    // ENDPOINT PARA MOSTRAR LAS LOCACIONES DE PASEADORES REGISTRADOS
    @GetMapping
    public List<LocacionPaseador> listarLocacionPaseadores(){
        return locacionPaseadorService.listarLocacionPaseador();
    }

    // ENDPOINT PARA MOSTRAR LA LOCACION DE UN PASEADOR POR SU ID
    @GetMapping("/{id}")
    public LocacionPaseador obtenerLocacionPaseadores(@PathVariable("id") Integer id_locacion_paseador){
        return  locacionPaseadorService.obtenerLocacionPaseador(id_locacion_paseador);
    }

    // ENDPOINT PARA GUARDAR NUEVAS LOCACIONES DE PASEADORES
    @PostMapping
    public ResponseEntity<String> guardarLocacionPaseador(@RequestBody LocacionPaseador locacionPaseador){
        locacionPaseadorService.guardarLocacionPaseador(locacionPaseador);
        return ResponseEntity.status(HttpStatus.CREATED).body("Locacion de paseador guardado exitosamente");
    }

    // ENDPOINT PARA ELIMINAR UNA LOCACION DE PASEADOR POR MEDIO DE SU ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarLocacionPaseador(@PathVariable("id") Integer id_locacion_paseador){
        locacionPaseadorService.eliminarLocacionPaseador(id_locacion_paseador);
        return ResponseEntity.status(HttpStatus.OK).body("Locacion del paseador eliminada correctamente");
    }

    // ENDPOINT PARA EDITAR LOS CAMPOS DE LA TABLA LOCACION_PASEADOR(se mantiene el ID)
    @PutMapping("/{id}")
    public ResponseEntity<LocacionPaseadorDTO> editarLocacionPaseador(
            @PathVariable("id") Integer id,
            @RequestBody LocacionPaseadorDTO locacionPaseadorDTO) {
        LocacionPaseadorDTO locacinPaseadorEditado = locacionPaseadorService.editarLocacionPaseador(id, locacionPaseadorDTO);
        return ResponseEntity.ok(locacinPaseadorEditado);
    }
}
