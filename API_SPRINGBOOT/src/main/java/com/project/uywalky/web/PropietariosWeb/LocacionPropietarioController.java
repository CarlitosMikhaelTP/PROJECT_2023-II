package com.project.uywalky.web.PropietariosWeb;

import com.project.uywalky.Entity.PropietariosEntitys.LocacionPropietario;
import com.project.uywalky.Service.LocacionPropietarioService;
import com.project.uywalky.Dto.PropietariosDTO.LocacionPropietarioDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/locacionPropietario")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class LocacionPropietarioController {

    // Inicializamos las clases para trabajar con este constructor con "final"
    private final LocacionPropietarioService locacionPropietarioService;

    // ENDPOINT PARA REGISTRAR LA LOCACION DEL PASEADOR
    @PostMapping("/registrar")
    public ResponseEntity<LocacionPropietarioDTO> registrarLocacionPropietario(@RequestBody LocacionPropietarioDTO locacionPropietarioDTO){
        LocacionPropietarioDTO locacionPropietarioRegistrado = locacionPropietarioService.registrarLocacionPropietario(locacionPropietarioDTO);
        return ResponseEntity.ok(locacionPropietarioRegistrado);
    }

    // ENDPOINT PARA MOSTRAR LAS LOCACIONES DE PROPIETARIOS REGISTRADOS
    @GetMapping
    public List<LocacionPropietario> listarLocacionPropietarios(){
        return locacionPropietarioService.listarLocacionPropietario();
    }

    // ENDPOINT PARA MOSTRAR LA LOCACION DE UN PROPIETARIO POR SU ID
    @GetMapping("/{id}")
    public LocacionPropietario obtenerLocacionPropietarios(@PathVariable("id") Integer id_locacion_propietario){
        return  locacionPropietarioService.obtenerLocacionPropietario(id_locacion_propietario);
    }

    // ENDPOINT PARA GUARDAR NUEVAS LOCACIONES DE PROPIETARIOS
    @PostMapping
    public ResponseEntity<String> guardarLocacionPropietario(@RequestBody LocacionPropietario locacionPropietario){
        locacionPropietarioService.guardarLocacionPropietario(locacionPropietario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Locacion de propietario guardado exitosamente");
    }

    // ENDPOINT PARA ELIMINAR UNA LOCACION DE PROPIETARIO POR MEDIO DE SU ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarLocacionPropietario(@PathVariable("id") Integer id_locacion_propietario){
        locacionPropietarioService.eliminarLocacionPropietario(id_locacion_propietario);
        return ResponseEntity.status(HttpStatus.OK).body("Locacion del propietario eliminada correctamente");
    }

    // ENDPOINT PARA EDITAR LOS CAMPOS DE LA TABLA LOCACION_PROPIETARIO(se mantiene el ID)
    @PutMapping("/{id}")
    public ResponseEntity<LocacionPropietarioDTO> editarLocacionPropietario(
            @PathVariable("id") Integer id,
            @RequestBody LocacionPropietarioDTO locacionPropietarioDTO) {
        LocacionPropietarioDTO locacinPropietarioditado = locacionPropietarioService.editarLocacionPropietario(id, locacionPropietarioDTO);
        return ResponseEntity.ok(locacinPropietarioditado);
    }
}
