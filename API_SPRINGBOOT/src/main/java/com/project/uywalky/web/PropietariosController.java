package com.project.uywalky.web;


import com.project.uywalky.Service.PropietariosService;
import com.project.uywalky.dto.PropietariosDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/propietarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class PropietariosController {

    private final PropietariosService propietariosService;

    @PostMapping("/registrar")
    public ResponseEntity<PropietariosDTO> registrarPropietarios(@RequestBody PropietariosDTO propietariosDTO){
        PropietariosDTO propietariosRegisrado = propietariosService.registrarPropietarios(propietariosDTO);
        return  ResponseEntity.ok(propietariosRegisrado);


    }
}
