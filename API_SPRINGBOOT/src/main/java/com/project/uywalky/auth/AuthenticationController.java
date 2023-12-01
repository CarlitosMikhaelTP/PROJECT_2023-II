package com.project.uywalky.auth;


import com.project.uywalky.Entity.TipoUsuario;
import com.project.uywalky.Service.TipoUsuarioService;
import com.project.uywalky.Service.UserService;
import com.project.uywalky.dto.NuevoUsuarioDTO;
import com.project.uywalky.exception.TipoUsuarioNotFoundException;
import com.project.uywalky.repository.TipoUsuarioRepository;
import com.project.uywalky.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // ENDPOINT para acceder a los servicios de edicion de usuarios
    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editUser(
            @PathVariable Integer id,
            @RequestBody NuevoUsuarioDTO request
    ){
        String newToken = service.editUserDetails(id, request);
        if (newToken != null){
            return ResponseEntity.ok("Contraseña actualizada. Nuevo Token generado: " + newToken);
        } else {
            return ResponseEntity.ok("Detalles de usuario actualizado, sin cambios en la contraseña.");
        }
    }

    // ENDPOINT para acceder al servicio de eliminar usuarios por id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id){
        service.deleteUserById(id);
        return ResponseEntity.ok("Usuario eliminado correctamente");
    }

    // ENDPOINT para obtener un usuario por su ID
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id){
        User user = service.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = service.getAllUsers();
        return ResponseEntity.ok(users);
    }

}

