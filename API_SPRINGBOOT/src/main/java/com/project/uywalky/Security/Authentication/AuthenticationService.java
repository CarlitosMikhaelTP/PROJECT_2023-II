package com.project.uywalky.Security.Authentication;

import com.project.uywalky.Entity.UsuariosEntitys.TipoUsuario;
import com.project.uywalky.Security.Authentication.Configuracion.ProjectService;
import com.project.uywalky.Dto.UsuariosDTO.NuevoUsuarioDTO;
import com.project.uywalky.Exceptions.NotFound.TipoUsuarioNotFoundException;
import com.project.uywalky.Repository.UsuariosRepo.TipoUsuarioRepository;
import com.project.uywalky.Entity.UsuariosEntitys.User;
import com.project.uywalky.Repository.UsuariosRepo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final ProjectService projectService;
    private final AuthenticationManager authenticationManager;
    private final TipoUsuarioRepository tipoUsuarioRepository;

    // Servicio para registrar al usuario
    // RegisterRequest funciona como el DTO aquí
    public AuthenticationResponse register(RegisterRequest request, Integer idTipoUsuario) {
        TipoUsuario tipoUsuario = tipoUsuarioRepository.findById(idTipoUsuario)
                .orElseThrow(() -> new TipoUsuarioNotFoundException("Tipo de usuario no encontrado"));
        var user = User.builder()
                .nombres(request.getNombres())
                .apellidos(request.getApellidos())
                .apodo(request.getApodo())
                .direccion(request.getDireccion())
                .edad(request.getEdad())
                .celular(request.getCelular())
                .dni(request.getDni())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .tipoUsuario(tipoUsuario)
                .build();
        System.out.println("Tipo de usuario antes de guardar: " + tipoUsuario);

        repository.save(user);
        var jwtToken = projectService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    // Servicio para autenticar al usuario
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        User user = repository.findByEmail(request.getEmail())
                        .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        user = repository.loadTipoUsuario(user.getId());
        var jwtToken = projectService.generateToken(user);

        TipoUsuario tipoUsuario = user.getTipoUsuario();
        Integer tipoUsuarioId = tipoUsuario.getIdTipoUsuario();

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        //Crear la respuesta con el token y el tipo de usuario
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .IdTipoUsuario(tipoUsuarioId)
                .build();
    }

    // Servicio para mostrar los usuarios creados
    public List<User> getAllUsers(){
        return repository.findAll();
    }

    // Servicio para mostrar un usuario por su ID
    public User getUserById(Integer id){
        return repository.findById(id)
                .orElseThrow(()-> new UsernameNotFoundException("Usuario no encontrado"));
    }

    // Servicio para editar Usuario
    public String editUserDetails(Integer id, NuevoUsuarioDTO request) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado "));
        // Actualizar los campos según la solicitud de edición
        if (request.getNombres() != null) {
            user.setNombres(request.getNombres());
        }
        if (request.getApellidos() != null) {
            user.setApellidos(request.getApellidos());
        }
        if (request.getApodo() != null) {
            user.setApodo(request.getApodo());
        }
        if (request.getDireccion() != null) {
            user.setDireccion(request.getDireccion());
        }
        if (request.getEdad() != null) {
            user.setEdad(request.getEdad());
        }
        if (request.getCelular() != null) {
            user.setCelular(request.getCelular());
        }
        if (request.getDni() != null) {
            user.setDni(request.getDni());
        }
        if (request.getEmail() != null) {
            user.setEmail(request.getEmail());
        }
        // Si la contraseña se actualiza, codifícala y genera un nuevo token
        if (request.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            // Generando un nuevo token con la informacion actualizada del usuario
            var jwtToken = projectService.generateToken(user);
            // Guardando cambios en la base de datos
            repository.save(user);
            // Devolver nuevo token
            return jwtToken;
        }
        // Guardando cambios en la base de datos
        repository.save(user);

        //Si no se actualiza el password devolver null o algun indicador
        return null;
    }

    // Creación de servicio para eliminar usuarios por ID
    public void deleteUserById(Integer id){
        // Verificar si el usuario existe
        User user = repository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        // Eliminando el usuario de la base de datos
        repository.delete(user);
    }

}