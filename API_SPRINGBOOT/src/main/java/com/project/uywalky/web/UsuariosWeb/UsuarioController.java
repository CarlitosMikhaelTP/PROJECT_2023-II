package com.project.uywalky.web.UsuariosWeb;

import com.project.uywalky.Dto.UsuariosDTO.NuevoUsuarioDTO;
import com.project.uywalky.Entity.UsuariosEntitys.User;
import com.project.uywalky.Security.Authentication.AuthenticationService;
import com.project.uywalky.Service.UserService;
import com.project.uywalky.Repository.UsuariosRepo.TipoUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UsuarioController {

    private final AuthenticationService service;
    private final TipoUsuarioRepository tipoUsuarioRepository;
    private final UserService userService;

    // ENDPOINT PARA EDITAR A UN USUARIO POR SU ID
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

    // ENDPOINT PARA ELIMINAR A UN USUARIO POR SU ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id){
        service.deleteUserById(id);
        return ResponseEntity.ok("Usuario eliminado correctamente");
    }

    // ENDPOINT PARA MOSTRAR UN USUARIO POR SU NUMERO DE ID
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id){
        User user = service.getUserById(id);
        return ResponseEntity.ok(user);
    }

    // ENDPOINT PARA MOSTRAR TODOS LOS USUARIOS REGISTRADOS
    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = service.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
