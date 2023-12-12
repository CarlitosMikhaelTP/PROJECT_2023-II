package com.project.uywalky.Service;

import com.project.uywalky.Entity.PaseadoresEntitys.LocacionPaseador;
import com.project.uywalky.Entity.PaseadoresEntitys.Paseadores;
import com.project.uywalky.Dto.PaseadoresDTO.LocacionPaseadorDTO;
import com.project.uywalky.Entity.UsuariosEntitys.User;
import com.project.uywalky.Exceptions.Exist.LocacionPaseadorExistenteException;
import com.project.uywalky.Exceptions.NotFound.LocacionPaseadorNotFoundException;
import com.project.uywalky.Exceptions.NotFound.PaseadorNotFounException;
import com.project.uywalky.Exceptions.NotFound.UserNotFoundException;
import com.project.uywalky.Repository.PaseadoresRepo.LocacionPaseadorRepository;
import com.project.uywalky.Repository.PaseadoresRepo.PaseadoresRepository;
import com.project.uywalky.Repository.UsuariosRepo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocacionPaseadorService {

    private final LocacionPaseadorRepository locacionPaseadorRepository;
    private final UserRepository userRepository;

    // Creación de servicio para registrar nuevas locaciones para el paseador
    public LocacionPaseadorDTO registrarLocacionPaseador(LocacionPaseadorDTO locacionPaseadorDTO){
        User user = userRepository.findById(locacionPaseadorDTO.getUsuarioId())
                .orElseThrow(()-> new UserNotFoundException("Id del paseador no encontrado"));
        if (locacionPaseadorRepository.existsByUser(user)){
            throw new LocacionPaseadorExistenteException("Esta locación ya tiene un id de paseador");
        }
        // Implementar las validaciones necesarias
        LocacionPaseador locacionPaseador = LocacionPaseador.builder()
                .user(user) // id del paseador
                .latitud(locacionPaseadorDTO.getLatitud())
                .longitud(locacionPaseadorDTO.getLongitud())
                .build();
        // Guardando la locacion en la base de datos usando el repositorio
        locacionPaseador = locacionPaseadorRepository.save(locacionPaseador);
        return new LocacionPaseadorDTO(locacionPaseador);
    }

    // Servicio para listos las locaciones para el paseador
    public List<LocacionPaseador> listarLocacionPaseador(){
        return locacionPaseadorRepository.findAll();
    }

    // Servicio para listar una locacion del paseador por su ID
    public LocacionPaseador obtenerLocacionPaseador(Integer id_locacion_paseador){
        return locacionPaseadorRepository.findById(id_locacion_paseador)
                .orElseThrow(()-> new LocacionPaseadorNotFoundException("Locacion del paseador no encontrado"));
    }

    // Servicio para guardar nuevas locaciones del paseador
    public void guardarLocacionPaseador(LocacionPaseador locacionPaseador){
        locacionPaseadorRepository.save(locacionPaseador);
    }

    // Servicio para eliminar una locación del paseador por su ID
    public void eliminarLocacionPaseador(Integer id_locacion_paseador){
        locacionPaseadorRepository.deleteById(id_locacion_paseador);
    }

    // Servicio para ediatar la locacion del paseador por su ID
    public LocacionPaseadorDTO editarLocacionPaseador(Integer id_locacion_paseador, LocacionPaseadorDTO locacionPaseadorDTO){
        // Buscando la locación del paseador por su ID
        LocacionPaseador locacionPaseadorExistente = locacionPaseadorRepository.findById(id_locacion_paseador)
                .orElseThrow(()-> new LocacionPaseadorNotFoundException("Locacion del paseador no encontrado"));
        // Obteniendo Locacion del PaseadorDTO a mantener los valores existentes sino se proporcionan en el DTO
        User user = locacionPaseadorExistente.getUser();
        if (locacionPaseadorDTO.getUsuarioId() != null){
            user = userRepository.findById(locacionPaseadorDTO.getUsuarioId())
                    .orElseThrow(()->new UserNotFoundException("Id del paseador no encontrado"));
        }
        // Actualizar los datos de la locacion del pasador con los valores del DTO
        locacionPaseadorExistente.setLatitud(locacionPaseadorDTO.getLatitud());
        locacionPaseadorExistente.setLongitud(locacionPaseadorDTO.getLongitud());
        locacionPaseadorExistente.setUser(user);
        // Actualizando los cambios en la base de datos usando el repositorio
        locacionPaseadorExistente = locacionPaseadorRepository.save(locacionPaseadorExistente);
        return new LocacionPaseadorDTO(locacionPaseadorExistente);
    }

}
