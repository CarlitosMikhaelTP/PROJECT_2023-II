package com.project.uywalky.Security.Authentication;


import com.project.uywalky.Entity.UsuariosEntitys.TipoUsuario;
import com.project.uywalky.Service.TipoUsuarioService;
import com.project.uywalky.Service.UserService;
import com.project.uywalky.Exceptions.NotFound.TipoUsuarioNotFoundException;
import com.project.uywalky.Repository.UsuariosRepo.TipoUsuarioRepository;
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


    //ENDPOINT para acceder a los servicios de Registros
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

    // ENDPOINT para acceder a los servicios de autenticación
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        AuthenticationResponse response = service.authenticate(request);

        return ResponseEntity.ok(service.authenticate(request));
    }
}

