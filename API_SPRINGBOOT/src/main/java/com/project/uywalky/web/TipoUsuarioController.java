package com.project.uywalky.web;

import com.project.uywalky.Entity.TipoUsuario;
import com.project.uywalky.Service.TipoUsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//////////////////////// DESPUES ELIMINAR /////////////////////77
@RestController
@RequestMapping("/api/v1/tiposUsuarios")
@CrossOrigin(origins = "http://localhost:3000")
public class TipoUsuarioController {

    private final TipoUsuarioService tipoUsuarioService;

    public TipoUsuarioController(TipoUsuarioService tipoUsuarioService) {
        this.tipoUsuarioService = tipoUsuarioService;
    }


    // Obteniendo todos los tipos de usuario
    @GetMapping("/tiposUsuarios")
    public ResponseEntity<List<TipoUsuario>> obtenerTiposUsuario(){
        List<TipoUsuario> tipoUsuarios = tipoUsuarioService.obtenerTodosLosTiposUsuario();
        return ResponseEntity.ok(tipoUsuarios);
    }

}
