package com.project.uywalky.Service;

import com.project.uywalky.Entity.MascotasEntitys.Mascotas;
import com.project.uywalky.Entity.MascotasEntitys.TipoMascota;
import com.project.uywalky.Dto.MascotasDTO.MascotasDTO;
import com.project.uywalky.Exceptions.NotFound.MascotasNotFoundException;
import com.project.uywalky.Exceptions.NotFound.TipoMascotaNotFoundException;
import com.project.uywalky.Repository.MascotasRepo.MascotaRepository;
import com.project.uywalky.Repository.MascotasRepo.TipoMascotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MascotasService {

    private final MascotaRepository mascotaRepository;
    private final TipoMascotaRepository tipoMascotaRepository;

    // Servicio para registrar una nueva mascota
    public MascotasDTO registarMascotas(MascotasDTO mascotasDTO) {
        TipoMascota tipoMascota = tipoMascotaRepository.findById(mascotasDTO.getTipoMascotaId())
                .orElseThrow(() -> new TipoMascotaNotFoundException("Id del tipo de mascota no encontrado."));
        // Implementando las validaciones necesarias
        Mascotas mascotas = Mascotas.builder()
                .nombre(mascotasDTO.getNombre())
                .raza(mascotasDTO.getRaza())
                .peso(mascotasDTO.getPeso())
                .edad(mascotasDTO.getEdad())
                .foto(mascotasDTO.getFoto())
                .necesidades(mascotasDTO.getNecesidades())
                .tipoMascota(tipoMascota)
                .build();
        // Guardando el registro en la base de datos usando el repositorio
        mascotas = mascotaRepository.save(mascotas);

        return new MascotasDTO(mascotas);
    }

    // Servicio para Listar las mascotas
    public List<Mascotas> listarMascotas() {
        return mascotaRepository.findAll();
    }

    //Servicio para Listar una mascota por su ID
    public Mascotas obtenerMascotas(Integer id_mascota) {
        return mascotaRepository.findById(id_mascota)
                .orElseThrow(() -> new MascotasNotFoundException("Mascota no encontrada"));
    }

    // Servicio para guardar los nuevos registros de mascotas
    public void guardarMascota(Mascotas mascotas) {
        mascotaRepository.save(mascotas);
    }

    // Servicio para eliminar un registro de mascota
    public void eliminarMascota(Integer id_mascota) {
        mascotaRepository.deleteById(id_mascota);
    }

    // Servicio para editar un registro de mascota
    public MascotasDTO editarMascota(Integer id_mascota, MascotasDTO mascotasDTO) {
        // Buscando a la mascota por su ID
        Mascotas mascotaExistente = mascotaRepository.findById(id_mascota)
                .orElseThrow(() -> new MascotasNotFoundException("Mascota no encontrada"));
        // Obtener tipo de mascota y del DTO o mantener los valores existentes si no se proporcionan en el DTO
        TipoMascota tipoMascota = mascotaExistente.getTipoMascota();
        if (mascotasDTO.getTipoMascotaId() != null) {
            tipoMascota = tipoMascotaRepository.findById(mascotasDTO.getTipoMascotaId())
                    .orElseThrow(() -> new TipoMascotaNotFoundException("Id del tipo de mascota no encontrado"));
        }
        // Actualizar los datos de la mascota con los valores del DTO
        mascotaExistente.setNombre(mascotasDTO.getNombre());
        mascotaExistente.setRaza(mascotasDTO.getRaza());
        mascotaExistente.setPeso(mascotasDTO.getPeso());
        mascotaExistente.setEdad(mascotasDTO.getEdad());
        mascotaExistente.setFoto(mascotasDTO.getFoto());
        mascotaExistente.setNecesidades(mascotasDTO.getNecesidades());
        mascotaExistente.setTipoMascota(tipoMascota);

        // Guardar los cambios en la base de datos usando el repositorio
        mascotaExistente = mascotaRepository.save(mascotaExistente);
        return new MascotasDTO(mascotaExistente);
    }

}
