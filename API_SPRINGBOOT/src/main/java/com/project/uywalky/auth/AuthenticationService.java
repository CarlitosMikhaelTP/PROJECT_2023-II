package com.project.uywalky.auth;

import com.project.uywalky.Entity.TipoUsuario;
import com.project.uywalky.config.ProjectService;
import com.project.uywalky.exception.TipoUsuarioNotFoundException;
import com.project.uywalky.repository.TipoUsuarioRepository;
import com.project.uywalky.user.User;
import com.project.uywalky.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final ProjectService projectService;
    private final AuthenticationManager authenticationManager;
    private final TipoUsuarioRepository tipoUsuarioRepository;
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
}