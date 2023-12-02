package com.project.uywalky.Service;

import com.project.uywalky.Entity.Categorias;
import com.project.uywalky.Entity.Paseadores;
import com.project.uywalky.dto.PaseadoresDTO;
import com.project.uywalky.exception.CategoriaNotFoundException;
import com.project.uywalky.exception.PaseadorExistenteException;
import com.project.uywalky.exception.PaseadorNotFounException;
import com.project.uywalky.exception.UserNotFoundException;
import com.project.uywalky.repository.CategoriasRepository;
import com.project.uywalky.repository.PaseadoresRepository;
import com.project.uywalky.user.User;
import com.project.uywalky.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaseadoresService {

    private final PaseadoresRepository paseadoresRepository;
    private final UserRepository userRepository;
    private final CategoriasRepository categoriasRepository;

    // Spring se encargará de proveer una instancia de PaseadoresRepository y pasarla al constructor
    // de PaseadoresService cuando se crea una instancia de PaseadoresService.
    // Forma de llamarlo distinta a la de arriba @Autowired // Para imyectar los métodos que se crean en PaseadoresRepository
    // public PaseadoresService (PaseadoresRepository paseadoresRepository){
       // this.paseadoresRepository = paseadoresRepository;
    //}

    // Servicio para registrar Nuevo Paseador
    public PaseadoresDTO registrarPaseadores(PaseadoresDTO paseadoresDTO){
        User user = userRepository.findById(paseadoresDTO.getUserId())
                .orElseThrow(()-> new UserNotFoundException("Id de usuario no encontrado"));
        // Lógica para verificar si el usuario ya tiene un paseador asignado
        if (paseadoresRepository.existsByUser(user)){
            throw new PaseadorExistenteException("Este usuario ya tiene una cuenta como paseador");
        }
        Categorias categorias = categoriasRepository.findById(paseadoresDTO.getId_categoria())
                .orElseThrow(() -> new CategoriaNotFoundException("Id de la categoria no encontrado"));
        // Implementar validaciones necesarias después
        Paseadores paseadores = Paseadores.builder()
                .calificacion(paseadoresDTO.getCalificacion())
                .descripcion(paseadoresDTO.getDescripcion())
                .experiencia(paseadoresDTO.getExperiencia())
                .ubicacion(paseadoresDTO.getUbicacion())
                .tarifa(paseadoresDTO.getTarifa())
                .saldo(paseadoresDTO.getSaldo())
                .disponibilidad(paseadoresDTO.getDisponibilidad())
                .foto(paseadoresDTO.getFoto())
                .categorias(categorias)
                .user(user)
                .build();
        // Guardando al paseador en la base de datos usando el repositorio
        paseadores =  paseadoresRepository.save(paseadores);

        return new PaseadoresDTO(paseadores);
    }

    // Servicio para Listar a los paseadores
    public List<Paseadores> listarPaseadores(){
        return paseadoresRepository.findAll();
    }

    // Servicio para Listar un paseador por su ID de paseador
    public Paseadores obtenerPaseadores(Integer id_paseador){
        return paseadoresRepository.findById(id_paseador)
                .orElseThrow(()-> new PaseadorNotFounException("Paseador no encontrado"));
    }

    // Servicio para guardar los nuevos registros
    public void guardarPaseador(Paseadores paseadores){
        paseadoresRepository.save(paseadores);
    }

    // Servicio para eliminar un registro
    public void eliminarPaseador(Integer id_paseador){
        paseadoresRepository.deleteById(id_paseador);
    }

    // Servicio para editar un registro de paseador:
    public PaseadoresDTO editarPaseador(Integer id_paseador, PaseadoresDTO paseadoresDTO) {
        // Buscando al paseador por su ID
        Paseadores paseadorExistente = paseadoresRepository.findById(id_paseador)
                .orElseThrow(() -> new PaseadorNotFounException("Paseador no encontrado"));
        // Obtener el usuario y la categoría del DTO o mantener los valores existentes si no se proporcionan en el DTO
        User user = paseadorExistente.getUser();
        if (paseadoresDTO.getUserId() != null) {
            user = userRepository.findById(paseadoresDTO.getUserId())
                    .orElseThrow(() -> new UserNotFoundException("Id de usuario no encontrado"));
        }
        Categorias categorias = paseadorExistente.getCategorias();
        if (paseadoresDTO.getId_categoria() != null) {
            categorias = categoriasRepository.findById(paseadoresDTO.getId_categoria())
                    .orElseThrow(() -> new CategoriaNotFoundException("Id de la categoría no encontrado"));
        }
        // Actualizar los datos del paseador con los valores del DTO
        paseadorExistente.setCalificacion(paseadoresDTO.getCalificacion());
        paseadorExistente.setDescripcion(paseadoresDTO.getDescripcion());
        paseadorExistente.setExperiencia(paseadoresDTO.getExperiencia());
        paseadorExistente.setUbicacion(paseadoresDTO.getUbicacion());
        paseadorExistente.setTarifa(paseadoresDTO.getTarifa());
        paseadorExistente.setSaldo(paseadoresDTO.getSaldo());
        paseadorExistente.setDisponibilidad(paseadoresDTO.getDisponibilidad());
        paseadorExistente.setFoto(paseadoresDTO.getFoto());
        paseadorExistente.setCategorias(categorias);


        // Guardar los cambios en la base de datos usando el repositorio
        paseadorExistente = paseadoresRepository.save(paseadorExistente);
        return new PaseadoresDTO(paseadorExistente);
    }


}
