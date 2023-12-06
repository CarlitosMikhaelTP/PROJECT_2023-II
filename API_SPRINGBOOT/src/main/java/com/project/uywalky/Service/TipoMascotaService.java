package com.project.uywalky.Service;

import com.project.uywalky.Entity.MascotasEntitys.TipoMascota;
import com.project.uywalky.Dto.MascotasDTO.TipoMascotaDTO;
import com.project.uywalky.Exceptions.NotFound.TipoMascotaNotFoundException;
import com.project.uywalky.Repository.MascotasRepo.TipoMascotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoMascotaService {

    private final TipoMascotaRepository tipoMascotaRepository;

    // Creación de servicio para reguistrar Tipos de Mascota
    public TipoMascotaDTO registrarTipoMascota(TipoMascotaDTO tipoMascotaDTO){
        TipoMascota tipoMascota  = TipoMascota.builder()
                .nombre(tipoMascotaDTO.getNombre())
                .build();
        // Guardando al tipo de mascota ingresado en la base de datos usando el repositorio
        tipoMascota = tipoMascotaRepository.save(tipoMascota);
        return new TipoMascotaDTO(tipoMascota);
    }

    // Servicio para listar los Tipos de Mascotas registrados
    public List<TipoMascota> listarTiposMascota(){
        return  tipoMascotaRepository.findAll();
    }

    // Servicio para listar un Tipo de Mascota por su ID
    public TipoMascota obtenerTipoMascota(Integer id_tipo_mascota){
        return tipoMascotaRepository.findById(id_tipo_mascota)
                .orElseThrow(()-> new TipoMascotaNotFoundException("Tipo de mascota no encontrado"));
    }

    // Servicio para guardar un nuevos registros de Tipos de mascotas
    public void guardarTipoMascota(TipoMascota tipoMascota){
        tipoMascotaRepository.save(tipoMascota);
    }

    // Servicio apra eliminar un registro de tipo de mascota por su ID
    public void eliminarTipoMascota(Integer id_tipo_mascota){
        tipoMascotaRepository.deleteById(id_tipo_mascota);
    }

    // Servicio para editar un registro de tipo de mascota por su id
    public TipoMascotaDTO editarTipoMascota(Integer id_tipo_mascota, TipoMascotaDTO tipoMascotaDTO){
        TipoMascota tipoMascotaExistente = tipoMascotaRepository.findById(id_tipo_mascota)
                .orElseThrow(()-> new TipoMascotaNotFoundException("Tipo de Mascota no encontrado"));
        // Actualizando los datos del propietario con los valores del DTO
        tipoMascotaExistente.setNombre(tipoMascotaDTO.getNombre());
        tipoMascotaExistente.setEstado(tipoMascotaDTO.getEstado());

        tipoMascotaExistente = tipoMascotaRepository.save(tipoMascotaExistente);
        return new TipoMascotaDTO(tipoMascotaExistente);
    }

}
