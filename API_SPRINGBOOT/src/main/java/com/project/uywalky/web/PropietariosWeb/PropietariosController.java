package com.project.uywalky.web.PropietariosWeb;


import com.project.uywalky.Entity.PropietariosEntitys.Propietarios;
import com.project.uywalky.Service.PropietariosService;
import com.project.uywalky.Dto.PropietariosDTO.PropietariosDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/propietarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class PropietariosController {

    private final PropietariosService propietariosService;

    // ENDPOINT PARA REGISTRAR PROPIETARIOS
    @PostMapping("/registrar")
    public ResponseEntity<PropietariosDTO> registrarPropietarios(@RequestBody PropietariosDTO propietariosDTO){
        PropietariosDTO propietariosRegisrado = propietariosService.registrarPropietarios(propietariosDTO);
        return  ResponseEntity.ok(propietariosRegisrado);
    }

    // Creación de Endpoint para mostrar los Propietarios registrados
    @GetMapping
    public List<Propietarios> listarPropietarios(){
        return propietariosService.listarPropietarios();
    }

    // Creación de Endpoint para mostrar al propietario por ID
    @GetMapping("/{id}")
    public Propietarios obtenerPropietarios(@PathVariable("id") Integer id_propietario){
        return propietariosService.obtenerPropietarios(id_propietario);
    }

    // Creación de ENDPOINT para guardar nuevos propietarios
    @PostMapping
    public ResponseEntity<String> guardarPropietario(@RequestBody Propietarios propietarios){
        propietariosService.guardarPropietario(propietarios);
        return ResponseEntity.status(HttpStatus.CREATED).body("Propietario guardado exitósamente");
    }

    // Creación de ENDPOINT para eliminar un propietario por su ID realizado
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPropietario(@PathVariable("id") Integer id_propietario){
        propietariosService.eliminarPropietario(id_propietario);
        return ResponseEntity.status(HttpStatus.OK).body("Propietario eliminado correctamente");
    }

    // Creacièn de ENDPOINT para editar un propietario por su ID realizado
    @PutMapping("/{id}")
    public ResponseEntity<PropietariosDTO> editarPropietario(
        @PathVariable("id") Integer id,
        @RequestBody PropietariosDTO propietariosDTO) {

        PropietariosDTO propietarioEditado = propietariosService.editarPropietario(id, propietariosDTO);
        return ResponseEntity.ok(propietarioEditado);
    }

}
