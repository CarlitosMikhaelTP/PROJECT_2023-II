package com.project.uywalky.Service;

import com.project.uywalky.Entity.*;
import com.project.uywalky.dto.TransaccionesDTO;
import com.project.uywalky.exception.*;
import com.project.uywalky.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransaccionesService {

    private final TransaccionesRepository transaccionesRepository;
    private final PaseadoresRepository paseadoresRepository;
    private final PropietariosRepository propietariosRepository;
    private final TiposTransaccionRepository tiposTransaccionRepository;
    private final EstadoTransaccionRepository estadoTransaccionRepository;

    // SERVICIO PARA REGISTRAR NUEVAS TRANSACCIONES
    public TransaccionesDTO registrarTransacciones(TransaccionesDTO transaccionesDTO){
        // Registrar el ID de paseador
        Paseadores paseadores = paseadoresRepository.findById(transaccionesDTO.getPaseadorId())
                .orElseThrow(()-> new PaseadorNotFounException("ID DEL PASEADOR NO ENCONTRADO"));
        // Registrar el ID de propietario
        Propietarios propietarios = propietariosRepository.findById(transaccionesDTO.getPropietarioId())
                .orElseThrow(()-> new PropietariosNotFoundException("ID DEL PROPIETARIO NO ENCONTRADO"));
        // Registrar el tipo de transaccion
        TiposTransaccion tiposTransaccion = tiposTransaccionRepository.findById(transaccionesDTO.getTiposTransaccionId())
                .orElseThrow(()-> new TipoTransaccionNotFoundException("ID DEL TIPO DE TRANSACCION NO ENCONTRADO"));
        // Registrar el estado de transaccion
        EstadoTransaccion estadoTransaccion = estadoTransaccionRepository.findById(transaccionesDTO.getEstadoTransaccionId())
                .orElseThrow(()-> new EstadoTransaccionNotFounException("ID DEL ESTADO DE TRANSACCION NO ENCONTRADO"));
        // Implementar las validaciones necesarias después
        Transacciones transacciones = Transacciones.builder()
                .paseadores(paseadores)
                .propietarios(propietarios)
                .tiposTransaccion(tiposTransaccion)
                .estadoTransaccion(estadoTransaccion)
                .monto(transaccionesDTO.getMonto())
                .build();
        // Guardando los cambios en la base de datos usando el repositorio
        transacciones = transaccionesRepository.save(transacciones);
        return new TransaccionesDTO(transacciones);
    }

    // SERVICIO PARA LISTAR LAS TRANSACCIONES
    public List<Transacciones> listarTransacciones(){
        return transaccionesRepository.findAll();
    }

    // SERVICIO PARA LISTAR UNA TRANSACCION POR SU ID
    public Transacciones obtenerTransaccion(Integer id_transaccion){
        return transaccionesRepository.findById(id_transaccion)
                .orElseThrow(()-> new TransaccionesNotFounException("TRANSACCION NO ENCONTRADA"));
    }

    // SERVICIO PARA GUARDAR UNA NUEVA TRANSACCION
    public void guardarTransaccion( Transacciones transacciones){
        transaccionesRepository.save(transacciones);
    }

    // SERVICIO PARA ELIMINAR UNA TRANSACCION POR ID
    public void eliminarTransaccion(Integer id_transaccion){
        transaccionesRepository.deleteById(id_transaccion);
    }

    // SERVICIO PARA EDITAR UNA TRANSACCION POR SU ID
    public TransaccionesDTO editarTransaccion(Integer id_transaccion, TransaccionesDTO transaccionesDTO){
        // BUSCANDO LA TRANSACCION POR SU ID
        Transacciones transaccionExistente = transaccionesRepository.findById(id_transaccion)
                .orElseThrow(()-> new TransaccionesNotFounException("TRANSACCION NO ENCONTRADA"));
        // OBTENIENDO EL PASEADOR Y MANTENIENDO VALORES SI NO SE CAMBIAN
        Paseadores paseadores = transaccionExistente.getPaseadores();
        if (transaccionesDTO.getPaseadorId() != null){
            paseadores = paseadoresRepository.findById(transaccionesDTO.getPaseadorId())
                    .orElseThrow(()-> new PaseadorNotFounException("ID DEL PASEADOR NO ENCONTRADO"));
        }
        // OBTENIENDO EL PROPIETARIO Y MANTENIENDO VALORES SI NO SE CAMBIAN
        Propietarios propietarios = transaccionExistente.getPropietarios();
        if (transaccionesDTO.getPropietarioId() != null){
            propietarios = propietariosRepository.findById(transaccionesDTO.getPropietarioId())
                    .orElseThrow(()-> new PropietariosNotFoundException("ID DEL PROPIETARIO NO ENCONTRADO"));
        }
        // OBTENIENDO EL TIPO DE TRANSACCION Y MANTENIENDO VALORES SI NO SE CAMBIAN
        TiposTransaccion tiposTransaccion = transaccionExistente.getTiposTransaccion();
        if (transaccionesDTO.getTiposTransaccionId() != null){
            tiposTransaccion = tiposTransaccionRepository.findById(transaccionesDTO.getTiposTransaccionId())
                    .orElseThrow(()-> new TipoTransaccionNotFoundException("ID DEL TIPO DE TRANSACCION NO ENCONTRADO"));
        }
        // OBTENIENDO EL TIPO DE ESTADO DE LA TRANSACCION Y MANTENIENDO VALORES SI NO SE CAMBIAN
        EstadoTransaccion estadoTransaccion = transaccionExistente.getEstadoTransaccion();
        if (transaccionesDTO.getEstadoTransaccionId() != null){
            estadoTransaccion = estadoTransaccionRepository.findById(transaccionesDTO.getEstadoTransaccionId())
                    .orElseThrow(()-> new EstadoTransaccionNotFounException("ID DEL ESTADO DE TRANSACCION NO ENCONTRADO"));
        }
        // ACTUALIZANDO LOS DATOS DE LA TRANSACCION
        transaccionExistente.setPaseadores(paseadores);
        transaccionExistente.setPropietarios(propietarios);
        transaccionExistente.setTiposTransaccion(tiposTransaccion);
        transaccionExistente.setEstadoTransaccion(estadoTransaccion);
        transaccionExistente.setMonto(transaccionesDTO.getMonto());

        // GUARDANDO LOS CAMBIOS EN LA BASE DE DATOS
        transaccionExistente = transaccionesRepository.save(transaccionExistente);
        return new TransaccionesDTO(transaccionExistente);

    }
}
