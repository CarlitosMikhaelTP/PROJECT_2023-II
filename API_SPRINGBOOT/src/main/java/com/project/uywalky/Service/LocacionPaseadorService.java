package com.project.uywalky.Service;

import com.project.uywalky.Entity.LocacionPaseador;
import com.project.uywalky.Entity.Paseadores;
import com.project.uywalky.dto.LocacionPaseadorDTO;
import com.project.uywalky.exception.LocacionPaseadorExistenteException;
import com.project.uywalky.exception.LocacionPaseadorNotFoundException;
import com.project.uywalky.exception.PaseadorNotFounException;
import com.project.uywalky.repository.LocacionPaseadorRepository;
import com.project.uywalky.repository.PaseadoresRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocacionPaseadorService {

    private final LocacionPaseadorRepository locacionPaseadorRepository;
    private final PaseadoresRepository paseadoresRepository;

    // Creación de servicio para registrar nuevas locaciones para el paseador
    public LocacionPaseadorDTO registrarLocacionPaseador(LocacionPaseadorDTO locacionPaseadorDTO){
        Paseadores paseadores = paseadoresRepository.findById(locacionPaseadorDTO.getPaseadoresId())
                .orElseThrow(()-> new PaseadorNotFounException("Id del paseador no encontrado"));
        if (locacionPaseadorRepository.existsByPaseadores(paseadores)){
            throw new LocacionPaseadorExistenteException("Esta locación ya tiene un id de paseador");
        }
        // Implementar las validaciones necesarias
        LocacionPaseador locacionPaseador = LocacionPaseador.builder()
                .paseadores(paseadores) // id del paseador
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
        Paseadores paseadores = locacionPaseadorExistente.getPaseadores();
        if (locacionPaseadorDTO.getPaseadoresId() != null){
            paseadores = paseadoresRepository.findById(locacionPaseadorDTO.getPaseadoresId())
                    .orElseThrow(()->new PaseadorNotFounException("Id del paseador no encontrado"));
        }
        // Actualizar los datos de la locacion del pasador con los valores del DTO
        locacionPaseadorExistente.setLatitud(locacionPaseadorDTO.getLatitud());
        locacionPaseadorExistente.setLongitud(locacionPaseadorDTO.getLongitud());
        locacionPaseadorExistente.setPaseadores(paseadores);
        // Actualizando los cambios en la base de datos usando el repositorio
        locacionPaseadorExistente = locacionPaseadorRepository.save(locacionPaseadorExistente);
        return new LocacionPaseadorDTO(locacionPaseadorExistente);
    }

}
