package com.example.demo.domain.serviceImpl.Paseos;

import com.example.demo.application.exceptions.PaseadoresExceptions.NotFound.PaseadorNotFoundException;
import com.example.demo.application.exceptions.PaseosExceptions.NotFound.ReservaNotFoundException;
import com.example.demo.application.exceptions.PropietariosExceptions.NotFound.PropietarioNotFoundException;
import com.example.demo.application.service.PaseosServices.ReservaService;
import com.example.demo.domain.entity.paseadores.Paseadores;
import com.example.demo.domain.entity.paseos.Reservas;
import com.example.demo.domain.entity.propietarios.Propietarios;
import com.example.demo.domain.repository.Paseadores.PaseadorRepository;
import com.example.demo.domain.repository.Paseos.ReservaRepository;
import com.example.demo.domain.repository.Propietarios.PropietarioRepository;
import com.example.demo.infrastructure.web.projection.UsuarioProjections.classBased.ReservaDTO;
import com.example.demo.infrastructure.web.projection.UsuarioProjections.interfaceBased.closed.ReservaProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;
    private final PropietarioRepository propietarioRepository;
    private final PaseadorRepository paseadorRepository;

    @Override
    public ReservaDTO registrarReservas(ReservaDTO reservaDTO) {
        Paseadores paseadores = paseadorRepository.findById(reservaDTO.getIdPaseador())
                .orElseThrow(()-> new PaseadorNotFoundException("Id del paseador no encontrado"));
        Propietarios propietarios = propietarioRepository.findById(reservaDTO.getIdPaseador())
                .orElseThrow(()-> new PropietarioNotFoundException("Id del propietario no encontrado"));

        Reservas reservas = Reservas.builder()
                .paseadores(paseadores)
                .propietarios(propietarios)
                .monto(reservaDTO.getMonto())
                .fechaReserva(reservaDTO.getFechaReserva())
                .duracionPaseo(reservaDTO.getDuracionPaseo())
                .detalles(reservaDTO.getDetalles())
                .lugarPaseo(reservaDTO.getLugarPaseo())
                .puntoEncuentro(reservaDTO.getPuntoEncuentro())
                .lugarPaseo(reservaDTO.getLugarPaseo())
                .build();
        // Guardando los cambios haciendo uso del repositorio
        reservas = reservaRepository.save(reservas);
        Integer IdReserva = reservaDTO.getIdReserva();
        Integer IdPropietario = reservaDTO.getIdPropietario();
        Integer IdPaseador = reservaDTO.getIdPaseador();
        BigDecimal Monto = reservaDTO.getMonto();

        return ReservaDTO.builder()
                .IdReserva(IdReserva)
                .IdPropietario(IdPropietario)
                .IdPaseador(IdPaseador)
                .monto(Monto)
                .build();
    }

    @Override
    public ReservaDTO editarReservas(Integer id_reserva, ReservaDTO reservaDTO) {
        Reservas reservasExistentes = reservaRepository.findById(id_reserva)
                .orElseThrow(()-> new ReservaNotFoundException("Id de la reserva no encontrada"));
        Paseadores paseadores = reservasExistentes.getPaseadores();
        if (reservaDTO.getIdPaseador() != null){
            paseadores = paseadorRepository.findById(reservaDTO.getIdPaseador())
                    .orElseThrow(()-> new PaseadorNotFoundException("Id del paseador no ecnontrado"));
        }
        Propietarios propietarios = reservasExistentes.getPropietarios();
        if (reservaDTO.getIdPropietario() != null){
            propietarios = propietarioRepository.findById(reservaDTO.getIdPropietario())
                    .orElseThrow(()-> new PropietarioNotFoundException("Id del propietario no encontrado"));
        }
        // Actualizando campos
        reservasExistentes.setMonto(reservaDTO.getMonto());
        // Guardando campos
        reservasExistentes = reservaRepository.save(reservasExistentes);

        // Personalizando respuesta
        Integer IdReserva = reservaDTO.getIdReserva();
        Integer IdPropietario = reservaDTO.getIdPropietario();
        Integer IdPaseador = reservaDTO.getIdPaseador();
        BigDecimal Monto = reservaDTO.getMonto();

        return ReservaDTO.builder()
                .IdReserva(IdReserva)
                .IdPropietario(IdPropietario)
                .IdPaseador(IdPaseador)
                .monto(Monto)
                .build();
    }

    @Override
    public List<ReservaProjection> findBy() {
        return reservaRepository.findBy();
    }

    @Override
    public Optional<ReservaProjection> findReservaByIdReserva(Integer IdReserva) {
        return reservaRepository.findReservasByIdReserva(IdReserva);
    }

    @Override
    public boolean deleteReservaById(Integer idReserva) {
        Reservas reservas = reservaRepository.findById(idReserva)
                .orElseThrow(()-> new ReservaNotFoundException("Id de la reserva no encontrada."));
        reservaRepository.delete(reservas);
        System.out.println("Se eliminó correctamente la reserva");
        return true;
    }
}
