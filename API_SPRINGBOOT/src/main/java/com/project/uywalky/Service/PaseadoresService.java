package com.project.uywalky.Service;

import com.project.uywalky.Entity.Categorias;
import com.project.uywalky.Entity.Paseadores;
import com.project.uywalky.dto.PaseadoresDTO;
import com.project.uywalky.exception.CategoriaNotFoundException;
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
        paseadores=  paseadoresRepository.save(paseadores);

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



}
