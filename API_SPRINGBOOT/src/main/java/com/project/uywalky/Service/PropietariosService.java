package com.project.uywalky.Service;


import com.project.uywalky.Entity.Mascotas;
import com.project.uywalky.Entity.Propietarios;
import com.project.uywalky.dto.PropietariosDTO;
import com.project.uywalky.exception.MascotasNotFoundException;
import com.project.uywalky.exception.PropietariosNotFoundException;
import com.project.uywalky.exception.UserNotFoundException;
import com.project.uywalky.repository.MascotaRepository;
import com.project.uywalky.repository.PropietariosRepository;
import com.project.uywalky.user.User;
import com.project.uywalky.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropietariosService {

    private final PropietariosRepository propietariosRepository;
    private final UserRepository userRepository;
    private final MascotaRepository mascotaRepository;

    // Creación de servicio para registrar nuevos propietarios
    public PropietariosDTO registrarPropietarios(PropietariosDTO propietariosDTO){
        User user = userRepository.findById(propietariosDTO.getUserId())
                .orElseThrow(()->new UserNotFoundException("Id del usuario no encontrado"));
        Mascotas mascotas = mascotaRepository.findById(propietariosDTO.getId_mascota())
                .orElseThrow(()-> new MascotasNotFoundException("Id de la mascota no encontrado"));
        // Implementar las validaciones necesarias
        Propietarios propietarios = Propietarios.builder()
                .calificacion(propietariosDTO.getCalificacion())
                .comentario(propietariosDTO.getComentario())
                .preferencias_paseo(propietariosDTO.getPreferencias_paseo())
                .saldo(propietariosDTO.getSaldo())
                .disponibilidad(propietariosDTO.getDisponibilidad())
                .foto(propietariosDTO.getFoto())
                .user(user)  // Escribir el Id del Usuario
                .mascotas(mascotas) // Escribir el Id de la mascota
                .build();
        // Guardando al propietario en la base de datos usando el repositorio
        propietarios = propietariosRepository.save(propietarios);

        return new PropietariosDTO(propietarios);
    }

    // Servicio para listar los propietarios registrados
    public List<Propietarios> listarPropietarios(){
        return propietariosRepository.findAll();
    }

    // Servicio para listar un propietario por su ID de propietario
    public Propietarios obtenerPropietarios(Integer id_propietario){
        return propietariosRepository.findById(id_propietario)
                .orElseThrow(()-> new PropietariosNotFoundException("Propietario no encontrado"));
    }

    // Servicio para guardar nuevos registros de propietarios
    public void guardarPropietario(Propietarios propietarios){
        propietariosRepository.save(propietarios);
    }

    // Servicio para eliminar un registro de propietario por su ID
    public void eliminarPropietario(Integer id_propietario){
        propietariosRepository.deleteById(id_propietario);
    }

    // Servicio para editar un registro de propietario
    public PropietariosDTO editarPropietario(Integer id_propietario, PropietariosDTO propietariosDTO){
        // Buscando el propietario por su ID
        Propietarios propietarioExistente = propietariosRepository.findById(id_propietario)
                .orElseThrow(() -> new PropietariosNotFoundException("Propietario no encontrado"));
        // Obteniendo el usuario y la mascota del DTO a mantener los valores existentes si no se proporcionan en el DTO

    }
}
