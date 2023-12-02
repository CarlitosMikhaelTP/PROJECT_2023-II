package com.project.uywalky.Service;

import com.project.uywalky.Entity.LocacionPaseador;
import com.project.uywalky.Entity.LocacionPropietario;
import com.project.uywalky.Entity.Paseadores;
import com.project.uywalky.Entity.Propietarios;
import com.project.uywalky.dto.LocacionPaseadorDTO;
import com.project.uywalky.dto.LocacionPropietarioDTO;
import com.project.uywalky.exception.*;
import com.project.uywalky.repository.LocacionPaseadorRepository;
import com.project.uywalky.repository.LocacionPropietarioRepository;
import com.project.uywalky.repository.PaseadoresRepository;
import com.project.uywalky.repository.PropietariosRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocacionPropietarioService {

    private final LocacionPropietarioRepository locacionPropietarioRepository;
    private final PropietariosRepository propietariosRepository;

    // Creación de servicio para registrar nuevas locaciones para el propietario
    public LocacionPropietarioDTO registrarLocacionPropietario(LocacionPropietarioDTO locacionPropietarioDTO){
        Propietarios propietarios = propietariosRepository.findById(locacionPropietarioDTO.getPropietariosId())
                .orElseThrow(()-> new PropietariosNotFoundException("Id del propietario no encontrado"));
        if (locacionPropietarioRepository.existsByPropietarios(propietarios)){
            throw new LocacionPropietarioExistenteException("Esta locación ya tiene un id de propietario");
        }
        // Implementar las validaciones necesarias
        LocacionPropietario locacionPropietario = LocacionPropietario.builder()
                .propietarios(propietarios) // id del paseador
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
        Propietarios propietarios = locacionPropietarioExistente.getPropietarios();
        if (locacionPropietarioDTO.getPropietariosId() != null){
            propietarios = propietariosRepository.findById(locacionPropietarioDTO.getPropietariosId())
                    .orElseThrow(()->new PropietariosNotFoundException("Id del propietario no encontrado"));
        }
        // Actualizando los cambios del propietario con los valores del DTO
        locacionPropietarioExistente.setLatitud(locacionPropietarioDTO.getLatitud());
        locacionPropietarioExistente.setLongitud(locacionPropietarioDTO.getLongitud());
        locacionPropietarioExistente.setPropietarios(propietarios);

        // Actualizando los cambios en la base de datos usando el repositorio
        locacionPropietarioExistente = locacionPropietarioRepository.save(locacionPropietarioExistente);
        return new LocacionPropietarioDTO(locacionPropietarioExistente);
    }

}

