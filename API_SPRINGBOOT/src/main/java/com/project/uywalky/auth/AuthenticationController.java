package com.project.uywalky.auth;

import com.project.uywalky.Entity.TipoUsuario;
import com.project.uywalky.Service.TipoUsuarioService;
import com.project.uywalky.Service.UserService;
import com.project.uywalky.exception.TipoUsuarioNotFoundException;
import com.project.uywalky.repository.TipoUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationController {

    private final AuthenticationService service;
    private final TipoUsuarioRepository tipoUsuarioRepository;
    private final UserService userService;
    private TipoUsuarioService tipoUsuarioService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        Integer idTipoUsuario = request.getTipoUsuarioId();
        TipoUsuario tipoUsuario = tipoUsuarioRepository.findById(idTipoUsuario)
                .orElseThrow(() -> new TipoUsuarioNotFoundException("Tipo de usuario no encontrado"));
        //Llamando al servicio de registro y pasándole el tipo de usuario asociado
        AuthenticationResponse response = service.register(request, idTipoUsuario);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        AuthenticationResponse response = service.authenticate(request);

        return ResponseEntity.ok(service.authenticate(request));
    }
}

