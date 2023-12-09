package com.example.demo.infrastructure.security.configuration.authentication;

import com.example.demo.application.exceptions.UsuariosExceptions.NotFound.TipoUsuarioNotFoundException;
import com.example.demo.domain.entity.usuariosEntitys.TiposUsuario;
import com.example.demo.domain.entity.usuariosEntitys.User;
import com.example.demo.domain.repository.UsuariosRepos.TipoUsuarioRepository;
import com.example.demo.domain.repository.UsuariosRepos.UserRepository;
import com.example.demo.infrastructure.security.configuration.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
        TiposUsuario tiposUsuario = tipoUsuarioRepository.findById(idTipoUsuario)
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
                .tiposUsuario(tiposUsuario)
                .build();
        System.out.println("Tipo de usuario antes de guardar: " + tiposUsuario);

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

        TiposUsuario tiposUsuario = user.getTiposUsuario();
        Integer tipoUsuarioId = tiposUsuario.getIdTipoUsuario();

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

}

