package com.project.uywalky.web;

import com.project.uywalky.Service.UserService;
import com.project.uywalky.dto.NuevoUsuarioDTO;
import com.project.uywalky.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//////////////////// DESPUES ELIMINAR ////////////////
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
    @Autowired
    private UserService service;

    // Estableciendo Endpoint para listar registro de users
    @GetMapping("/users")
    //Escoger la interface para evitar errores
    public List<User> listarUsers(){
        return service.listarUsers();
    }

    // Estableciendo Endpoiunt para obtener registro por número de ID
    @GetMapping("/users/{id}")
    public ResponseEntity<User> obtenerUsers(@PathVariable Integer id){
        try{
            User user = service.obtenerUsers(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    //Estableciendo Endpoint para guardar registros
    @PostMapping("/users")
    public ResponseEntity<User> guardarUsers(@RequestBody User user){
        service.guardarUsers(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    // Estableciendo Endpoint para actualizar registros
    @PutMapping("/users/{id}")
    public ResponseEntity<?> actualizarUsers(@RequestBody User nuevosDatosUser, @PathVariable Integer id){
        try{
            User userExistente = service.obtenerUsers(id);
            if (userExistente != null){
                userExistente.setNombres(nuevosDatosUser.getNombres());
                userExistente.setApellidos(nuevosDatosUser.getApellidos());
                userExistente.setTipoUsuario(nuevosDatosUser.getTipoUsuario());
                userExistente.setApodo(nuevosDatosUser.getApodo());
                userExistente.setDireccion(nuevosDatosUser.getDireccion());
                userExistente.setEdad(nuevosDatosUser.getEdad());
                userExistente.setCelular(nuevosDatosUser.getCelular());
                userExistente.setDni(nuevosDatosUser.getDni());
                userExistente.setEmail(nuevosDatosUser.getEmail());
                userExistente.setPassword(nuevosDatosUser.getPassword());

                service.guardarUsers(userExistente);
                return new ResponseEntity<>(userExistente, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Estableciendo EndpPoint que eliminará registros según el ID del usuario
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> EliminarUsers(@PathVariable Integer id){
        try {
            service.eliminarUsers(id);
            return new ResponseEntity<>("Usuario eliminado correctamente", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("No se pudo eliminar al usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Registrando un nuevo usuario con su tipo correspondiente
    @PostMapping("/usuarios")
    public ResponseEntity<?> registrarUsuarios(@RequestBody NuevoUsuarioDTO nuevoUsuarioDTO){
        service.registrarUsuarioConTipo(nuevoUsuarioDTO);
        return ResponseEntity.ok("Usuario registrado correctamente");
    }




}

