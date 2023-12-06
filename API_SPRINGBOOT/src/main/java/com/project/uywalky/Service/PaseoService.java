package com.project.uywalky.Service;

import com.project.uywalky.Entity.PaseosEntitys.Paseos;
import com.project.uywalky.Entity.PaseosEntitys.Reservas;
import com.project.uywalky.Dto.PaseosDTO.PaseosDTO;
import com.project.uywalky.Exceptions.Exist.PaseadorExistenteException;
import com.project.uywalky.Exceptions.NotFound.PaseoNotFoundException;
import com.project.uywalky.Exceptions.NotFound.ReservaNotFoundException;
import com.project.uywalky.Repository.PaseosRepo.PaseosRepository;
import com.project.uywalky.Repository.PaseosRepo.ReservasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaseoService {

    private final PaseosRepository paseosRepository;
    private final ReservasRepository reservasRepository;

    // SERVICIO PARA REGISTRAR NUEVOS PASEOS
    public PaseosDTO registrarPaseos(PaseosDTO paseosDTO){
        Reservas reservas = reservasRepository.findById(paseosDTO.getReservaId())
                .orElseThrow(()-> new ReservaNotFoundException("ID de la reserva no encontrado"));
        // Lógica para verificar si el paseo ya tiene una reserva asignada
        if (paseosRepository.existsByReservas(reservas)){
            throw new PaseadorExistenteException("Esta reserva ya está asociada con un paseo");
        }
        // Implementar validaciones necesarias después
        Paseos paseos = Paseos.builder()
                .reservas(reservas)
                .comentario(paseosDTO.getComentario())
                .calificacion(paseosDTO.getCalificacion())
                .costo(paseosDTO.getCosto())
                .fecha_paseo(paseosDTO.getFecha_paseo())
                .hora_paseo(paseosDTO.getHora_paseo())
                .duracion_real(paseosDTO.getDuracion_real())
                .lugar(paseosDTO.getLugar())
                .build();
        // Guardando el paseo en la base de datos usando el repositorio
        paseos = paseosRepository.save(paseos);
        return new PaseosDTO(paseos);
    }

    // Servicio para Listar los paseos
    public List<Paseos> listarPaseos(){
        return paseosRepository.findAll();
    }

    // Servicio para Listar un paseo por su ID
    public Paseos obtenerPaseos(Integer idPaseo){
        return paseosRepository.findById(idPaseo)
                .orElseThrow(()-> new PaseoNotFoundException("Paseo no encontrado"));
    }

    // Servicio para guardar los nuevos paseos
    public void guardarPaseo(Paseos paseos){
        paseosRepository.save(paseos);
    }

    // Servicio para eliminar un paseo
    public void eliminarPaseo(Integer idPaseo){
        paseosRepository.deleteById(idPaseo);
    }

    // Servicio para editar un registro de paseo por id
    public PaseosDTO editarPaseo(Integer idPaseo, PaseosDTO paseosDTO){
        // Buscando el paseo por su ID
        Paseos paseoExistente = paseosRepository.findById(idPaseo)
                .orElseThrow(()-> new PaseoNotFoundException("Paseo no encontrado"));
        // Obteniendo la reserva o mantener los valores existentes sino se proporcionan
        Reservas reservas = paseoExistente.getReservas();
        if (paseosDTO.getReservaId() != null){
            reservas = reservasRepository.findById(paseosDTO.getReservaId())
                    .orElseThrow(()-> new ReservaNotFoundException("ID de la reserva no encontrado"));
        }
        // Actualizando los datos del paseador con los valores del DTO
        paseoExistente.setReservas(reservas);
        paseoExistente.setComentario(paseosDTO.getComentario());
        paseoExistente.setCalificacion(paseosDTO.getCalificacion());
        paseoExistente.setCosto(paseosDTO.getCosto());
        paseoExistente.setFecha_paseo(paseosDTO.getFecha_paseo());
        paseoExistente.setHora_paseo(paseosDTO.getHora_paseo());
        paseoExistente.setDuracion_real(paseosDTO.getDuracion_real());
        paseoExistente.setLugar(paseosDTO.getLugar());

        // Guardar los cambios en la base de datos usando el repositorio
        paseoExistente = paseosRepository.save(paseoExistente);
        return new PaseosDTO(paseoExistente);
    }
}
