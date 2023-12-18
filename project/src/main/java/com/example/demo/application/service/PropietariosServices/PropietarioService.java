package com.example.demo.application.service.PropietariosServices;

import com.example.demo.domain.entity.propietarios.Propietarios;
import com.example.demo.infrastructure.web.projection.UsuarioProjections.classBased.PropietarioDTO;
import com.example.demo.infrastructure.web.projection.UsuarioProjections.interfaceBased.closed.PropietarioProjection;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface PropietarioService {

    // Definiendo interfaz para realizar el registro de Propietarios
    PropietarioDTO registrarPropietario(PropietarioDTO propietarioDTO);

    // Definiendo interfaz para realizar la edición de Propietarios
    PropietarioDTO editarPropietario(Integer id_propietario, PropietarioDTO propietarioDTO);

    // Definiendo interfaz para mostrar a los propietarios registrados


    // Definiendo Interfaz para mostrar a propietario por su ID
    Optional<PropietarioProjection> findPropietariosByIdPropietario(Integer idPropietario);

    //Definiendo Interfaz para eliminar un propietario por su ID
    boolean deletePropietarioById(Integer idPropietario);
    List<PropietarioProjection> obtenerPropietariosDisponibles();

    void actualizarFotoPropietario(Integer propietarioId, MultipartFile foto) throws Exception;
}
