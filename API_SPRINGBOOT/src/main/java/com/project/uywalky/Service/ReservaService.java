package com.project.uywalky.Service;

import com.project.uywalky.Entity.Paseadores;
import com.project.uywalky.Entity.Propietarios;
import com.project.uywalky.Entity.Reservas;
import com.project.uywalky.dto.ReservasDTO;
import com.project.uywalky.exception.PaseadorNotFounException;
import com.project.uywalky.exception.PropietariosNotFoundException;
import com.project.uywalky.exception.ReservaNotFoundException;
import com.project.uywalky.repository.PaseadoresRepository;
import com.project.uywalky.repository.PropietariosRepository;
import com.project.uywalky.repository.ReservasRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //generar automáticamente un constructor que incluye todos los campos marcados como final o aquellos que no tienen anotaciones de acceso (como @Getter o @Setter).
public class ReservaService {

    private final ReservasRepository reservasRepository;
    private final PaseadoresRepository paseadoresRepository;
    private final PropietariosRepository propietariosRepository;

    // Generando servicio para registrar una nueva reserva
    public ReservasDTO registrarReservas(ReservasDTO reservasDTO){
        Paseadores paseadores = paseadoresRepository.findById(reservasDTO.getPaseadorId())
                .orElseThrow(()-> new PaseadorNotFounException("Id del paseador no encontrado"));
        Propietarios propietarios = propietariosRepository.findById(reservasDTO.getPropietarioId())
                .orElseThrow(()-> new PropietariosNotFoundException("ID del propietario no ecnontrado."));
        Reservas reservas = Reservas.builder()
                .paseadores(paseadores)
                .propietarios(propietarios)
                .costo(reservasDTO.getCosto())
                .fecha_reserva(reservasDTO.getFecha_reserva())
                .hora_reserva(reservasDTO.getHora_reserva())
                .punto_encuentro(reservasDTO.getPunto_encuentro())
                .duracion(reservasDTO.getDuracion())
                .lugar_paseo(reservasDTO.getLugar_paseo())
                .build();
        // Guardando los cambios en la base de datos usando el repositorio
        reservas = reservasRepository.save(reservas);
        return new ReservasDTO(reservas);
    }

    // Servicio para listar las reservas realizadas
    public List<Reservas> listarReservas(){
        return reservasRepository.findAll();
    }

    // Servicio para listar una reserva por su ID
    public Reservas obtenerReserva(Integer id_reserva){
        return reservasRepository.findById(id_reserva)
                .orElseThrow(()-> new ReservaNotFoundException("ID de la reserva no encontrado"));
    }

    // Servicio para guardar las nuevas reservas
    public void guardarReserva(Reservas reservas){
        reservasRepository.save(reservas);
    }

    // Servicio para eliminar una reserva
    public void eiminarReserva(Integer id_reserva){
        reservasRepository.deleteById(id_reserva);
    }

    // Servicio para editar una reserva
    public ReservasDTO editarReserva(Integer id_reserva, ReservasDTO reservasDTO){
        // Buscando la reserca por su ID
        Reservas reservaExistente = reservasRepository.findById(id_reserva)
                .orElseThrow(()-> new ReservaNotFoundException("ID de la reserva no encontrado"));
        // Obteniendo el id de pasador y id de propietario
        Paseadores paseadores = reservaExistente.getPaseadores();
        if (reservasDTO.getPaseadorId() != null){
            paseadores = paseadoresRepository.findById(reservasDTO.getPaseadorId())
                    .orElseThrow(()-> new PaseadorNotFounException("Id del paseador no encontrado"));
        }
        Propietarios propietarios = reservaExistente.getPropietarios();
        if (reservasDTO.getPropietarioId() != null){
            propietarios = propietariosRepository.findById(reservasDTO.getPropietarioId())
                    .orElseThrow(()-> new PropietariosNotFoundException("Id del propietario no encontrado"));
        }
        // Actualizando los datos de la reserva con los valores del DTO
        reservaExistente.setPaseadores(paseadores);
        reservaExistente.setPropietarios(propietarios);
        reservaExistente.setCosto(reservasDTO.getCosto());
        reservaExistente.setFecha_reserva(reservasDTO.getFecha_reserva());
        reservaExistente.setHora_reserva(reservasDTO.getHora_reserva());
        reservaExistente.setPunto_encuentro(reservasDTO.getPunto_encuentro());
        reservaExistente.setLugar_paseo(reservasDTO.getLugar_paseo());
        reservaExistente.setDuracion(reservasDTO.getDuracion());

        // Guardando los cambios en la base de datos usando el repositorio
        reservaExistente = reservasRepository.save(reservaExistente);
        return new ReservasDTO(reservaExistente);

    }

}
