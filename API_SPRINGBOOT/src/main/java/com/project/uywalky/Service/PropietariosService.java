package com.project.uywalky.Service;


import com.project.uywalky.Entity.Mascotas;
import com.project.uywalky.Entity.Propietarios;
import com.project.uywalky.dto.PropietariosDTO;
import com.project.uywalky.exception.MascotasNotFoundException;
import com.project.uywalky.exception.PropietarioExistenteException;
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
        // Lógica para verificar si el usuario ya tiene un propietario asignado
        if (propietariosRepository.existsByUser(user)){
            throw new PropietarioExistenteException("Este usuario ya tiene un propietario");
        }

        Mascotas mascotas = mascotaRepository.findById(propietariosDTO.getId_mascota())
                .orElseThrow(()-> new MascotasNotFoundException("Id de la mascota no encontrado"));
        // Implementar las validaciones necesarias
        Propietarios propietarios = Propietarios.builder()
                .calificacion(propietariosDTO.getCalificacion())
                .comentario(propietariosDTO.getComentario())
                .preferencias_paseo(propietariosDTO.getPreferencias_paseo())
                .saldo(propietariosDTO.getSaldo())
                .disponibilidad(propietariosDTO.getDisponibilidad())
                .ubicacion(propietariosDTO.getUbicacion())
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
       User user = propietarioExistente.getUser();
       if (propietariosDTO.getUserId() != null){
           user = userRepository.findById(propietariosDTO.getUserId())
                   .orElseThrow(() -> new UserNotFoundException("Id de usuario no encontrado"));
       }
       Mascotas mascotas = propietarioExistente.getMascotas();
       if (propietariosDTO.getId_mascota() != null){
           mascotas = mascotaRepository.findById(propietariosDTO.getId_mascota())
                   .orElseThrow(() -> new MascotasNotFoundException("Id de la mascota no encontrado"));
       }
       // Actualizando los datos del propietario con los valores de DTO
        propietarioExistente.setCalificacion(propietariosDTO.getCalificacion());
        propietarioExistente.setComentario(propietariosDTO.getComentario());
        propietarioExistente.setPreferencias_paseo(propietariosDTO.getPreferencias_paseo());
        propietarioExistente.setSaldo(propietariosDTO.getSaldo());
        propietarioExistente.setDisponibilidad(propietariosDTO.getDisponibilidad());
        propietarioExistente.setUbicacion(propietariosDTO.getUbicacion());
        propietarioExistente.setFoto(propietariosDTO.getFoto());
        propietarioExistente.setMascotas(mascotas);

        // Guardando los cambios en la base de datos usando el repositorio
        propietarioExistente = propietariosRepository.save(propietarioExistente);
        return new PropietariosDTO(propietarioExistente);

    }
}
