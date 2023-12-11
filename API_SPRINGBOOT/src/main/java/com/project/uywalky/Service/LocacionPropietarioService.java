package com.project.uywalky.Service;

import com.project.uywalky.Entity.PropietariosEntitys.LocacionPropietario;
import com.project.uywalky.Entity.PropietariosEntitys.Propietarios;
import com.project.uywalky.Dto.PropietariosDTO.LocacionPropietarioDTO;
import com.project.uywalky.Entity.UsuariosEntitys.User;
import com.project.uywalky.Exceptions.Exist.LocacionPropietarioExistenteException;
import com.project.uywalky.Exceptions.NotFound.LocacionPropietarioNotFoundException;
import com.project.uywalky.Exceptions.NotFound.PropietariosNotFoundException;
import com.project.uywalky.Exceptions.NotFound.UserNotFoundException;
import com.project.uywalky.Repository.PropietariosRepo.LocacionPropietarioRepository;
import com.project.uywalky.Repository.PropietariosRepo.PropietariosRepository;
import com.project.uywalky.Repository.UsuariosRepo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocacionPropietarioService {

    private final LocacionPropietarioRepository locacionPropietarioRepository;
    private final UserRepository userRepository;

    // Creación de servicio para registrar nuevas locaciones para el propietario
    public LocacionPropietarioDTO registrarLocacionPropietario(LocacionPropietarioDTO locacionPropietarioDTO){
        User user = userRepository.findById(locacionPropietarioDTO.getUsuarioId())
                .orElseThrow(()-> new PropietariosNotFoundException("Id del propietario no encontrado"));
        if (locacionPropietarioRepository.existsByUser(user)){
            throw new LocacionPropietarioExistenteException("Esta locación ya tiene un id de usuario");
        }
        // Implementar las validaciones necesarias
        LocacionPropietario locacionPropietario = LocacionPropietario.builder()
                .user(user) // id del paseador
                .latitud(locacionPropietarioDTO.getLatitud())
                .longitud(locacionPropietarioDTO.getLongitud())
                .build();
        // Guardando la locacion en la base de datos usando el repositorio
        locacionPropietario = locacionPropietarioRepository.save(locacionPropietario);
        return new LocacionPropietarioDTO(locacionPropietario);
    }

    // Servicio para listos las locaciones para el propietario
    public List<LocacionPropietario> listarLocacionPropietario(){
        return locacionPropietarioRepository.findAll();
    }

    // Servicio para listar una locacion del propietario por su ID
    public LocacionPropietario obtenerLocacionPropietario(Integer id_locacion_propietario){
        return locacionPropietarioRepository.findById(id_locacion_propietario)
                .orElseThrow(()-> new LocacionPropietarioNotFoundException("Locacion del propietario no encontrado"));
    }

    // Servicio para guardar nuevas locaciones del propietario por su ID
    public void guardarLocacionPropietario(LocacionPropietario locacionPropietario){
        locacionPropietarioRepository.save(locacionPropietario);
    }

    // Servicio para eliminar una locación del propietario por su ID
    public void eliminarLocacionPropietario(Integer id_locacion_propietario){
        locacionPropietarioRepository.deleteById(id_locacion_propietario);
    }

    // Servicio para ediatar la locacion del propietario por su ID
    public LocacionPropietarioDTO editarLocacionPropietario(Integer id_locacion_propietario, LocacionPropietarioDTO locacionPropietarioDTO){
        // Buscando la locación del propietario  por su ID
        LocacionPropietario locacionPropietarioExistente = locacionPropietarioRepository.findById(id_locacion_propietario)
                .orElseThrow(()-> new LocacionPropietarioNotFoundException("Locacion del propietario no encontrado"));
        // Obteniendo Locacion del PropietarioDTO a mantener los valores existentes sino se proporcionan en el DTO
        User user = locacionPropietarioExistente.getUser();
        if (locacionPropietarioDTO.getUsuarioId() != null){
            user = userRepository.findById(locacionPropietarioDTO.getUsuarioId())
                    .orElseThrow(()->new UserNotFoundException("Id del propietario no encontrado"));
        }
        // Actualizando los cambios del propietario con los valores del DTO
        locacionPropietarioExistente.setLatitud(locacionPropietarioDTO.getLatitud());
        locacionPropietarioExistente.setLongitud(locacionPropietarioDTO.getLongitud());
        locacionPropietarioExistente.setUser(user);

        // Actualizando los cambios en la base de datos usando el repositorio
        locacionPropietarioExistente = locacionPropietarioRepository.save(locacionPropietarioExistente);
        return new LocacionPropietarioDTO(locacionPropietarioExistente);
    }

}

