package com.example.demo.domain.serviceImpl.Paseadores;
import com.example.demo.application.exceptions.PaseadoresExceptions.Exist.PaseadorExistenteException;
import com.example.demo.application.exceptions.PaseadoresExceptions.NotFound.CategoriaNotFoundException;
import com.example.demo.application.exceptions.PaseadoresExceptions.NotFound.FileProcessingException;
import com.example.demo.application.exceptions.UsuariosExceptions.NotFound.UserNotFoundException;
import com.example.demo.application.service.PaseadoresServices.PaseadorService;
import com.example.demo.domain.entity.paseadores.Categorias;
import com.example.demo.domain.entity.paseadores.Paseadores;
import com.example.demo.domain.entity.usuarios.User;
import com.example.demo.domain.repository.Paseadores.CategoriaRepository;
import com.example.demo.domain.repository.Paseadores.PaseadorRepository;
import com.example.demo.domain.repository.Usuarios.UserRepository;
import com.example.demo.infrastructure.web.projection.UsuarioProjections.classBased.PaseadoresDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
@RequiredArgsConstructor
public class PaseadorServiceImpl implements PaseadorService {

    private final PaseadorRepository paseadorRepository;
    private final UserRepository userRepository;
    private final CategoriaRepository categoriaRepository;


    @Override
    public PaseadoresDTO registrarPaseadores(PaseadoresDTO paseadoresDTO, MultipartFile foto) {
        User user = userRepository.findById(paseadoresDTO.getIdUsuario())
                .orElseThrow(() -> new UserNotFoundException("Id de usuario no encontrado"));

        if (paseadorRepository.existsByUser(user)) {
            throw new PaseadorExistenteException("Este usuario ya tiene una cuenta como paseador");
        }

        Categorias categorias = categoriaRepository.findById(paseadoresDTO.getIdCategoria())
                .orElseThrow(() -> new CategoriaNotFoundException("Id de la categoria no encontrado"));

        Paseadores paseadores = construirPaseadorDesdeDTO(paseadoresDTO, user, categorias);

        try {
            // Guardar la foto como bytes en el objeto Paseadores
            if (foto != null && !foto.isEmpty()) {
                paseadores.setFoto(foto.getBytes());
            }
        } catch (IOException e) {
            throw new FileProcessingException("Error al procesar la foto del paseador");
        }

        paseadores = paseadorRepository.save(paseadores);
        return new PaseadoresDTO(paseadores, foto);
    }

    private Paseadores construirPaseadorDesdeDTO(PaseadoresDTO paseadoresDTO, User user, Categorias categorias) {
        return Paseadores.builder()
                .calificacion(paseadoresDTO.getCalificacion())
                .descripcion(paseadoresDTO.getDescripcion())
                .experiencia(paseadoresDTO.getExperiencia())
                .ubicacion(paseadoresDTO.getUbicacion())
                .tarifa(paseadoresDTO.getTarifa())
                .saldo(paseadoresDTO.getSaldo())
                .disponibilidad(paseadoresDTO.getDisponibilidad())
                .categorias(categorias)
                .user(user)
                .build();
    }
}


