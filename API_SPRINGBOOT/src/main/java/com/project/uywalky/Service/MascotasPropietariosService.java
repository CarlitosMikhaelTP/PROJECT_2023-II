package com.project.uywalky.Service;

import com.project.uywalky.Entity.MascotasEntitys.Mascotas;
import com.project.uywalky.Entity.MascotasEntitys.MascotasPropietarios;
import com.project.uywalky.Entity.PropietariosEntitys.Propietarios;
import com.project.uywalky.Dto.MascotasDTO.Mascotas_PropietariosDTO;
import com.project.uywalky.Exceptions.NotFound.MascotasNotFoundException;
import com.project.uywalky.Exceptions.NotFound.MascotasPropietariosNotFoundException;
import com.project.uywalky.Exceptions.NotFound.PropietariosNotFoundException;
import com.project.uywalky.Repository.MascotasRepo.MascotaRepository;
import com.project.uywalky.Repository.MascotasRepo.Mascotas_PropietariosRepository;
import com.project.uywalky.Repository.PropietariosRepo.PropietariosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MascotasPropietariosService {

    private final Mascotas_PropietariosRepository mascotasPropietariosRepository;
    private final MascotaRepository mascotaRepository;
    private final PropietariosRepository propietariosRepository;

    // Creación de servicio para registrar nuevos tabla intermedia de mascotas y propietarios
    public Mascotas_PropietariosDTO registrarMascotasPropietarios(Mascotas_PropietariosDTO mascotasPropietariosDTO){
        Mascotas mascotas = mascotaRepository.findById(mascotasPropietariosDTO.getMascotasId())
                .orElseThrow(()->new MascotasNotFoundException("No se encontró el ID de la mascota"));
        Propietarios propietarios= propietariosRepository.findById(mascotasPropietariosDTO.getPropietariosId())
                .orElseThrow(()-> new PropietariosNotFoundException("Id del porpietario no encontrado"));
        // Implementar las validaciones necesarias
        MascotasPropietarios mascotasPropietarios = MascotasPropietarios.builder()
                .estado(mascotasPropietariosDTO.getEstado())
                .mascotas(mascotas)
                .propietarios(propietarios)
                .build();
        // GUardando al mascota_propietario en la base de datos usando el repositorio
        mascotasPropietarios = mascotasPropietariosRepository.save(mascotasPropietarios);
        return new Mascotas_PropietariosDTO(mascotasPropietarios);
    }

    // Servicio para listar los mascotas propietarios registrados
    public List<MascotasPropietarios> listarMascotasPropietarios(){
        return mascotasPropietariosRepository.findAll();
    }

    // Servicio para listar un MascotaPropietario por su ID
    public MascotasPropietarios obtenerMascotasPropietarios(Integer id_mascota_propietario){
        return mascotasPropietariosRepository.findById(id_mascota_propietario)
                .orElseThrow(()-> new MascotasPropietariosNotFoundException("Mascota_Propietario no encontrado"));
    }

    // Servicio para guardar nuevos registros
    public void guardarMascotasPropietarios(MascotasPropietarios mascotasPropietarios){
        mascotasPropietariosRepository.save(mascotasPropietarios);
    }

    // Servicio para eliminar por ID
    public void eliminarMascotasPropietarios(Integer id_mascota_propietario){
        mascotasPropietariosRepository.deleteById(id_mascota_propietario);
    }

    // Servicio para editar un registro por ID
    public Mascotas_PropietariosDTO editarMascotaPropietario(Integer id_mascota_propietario, Mascotas_PropietariosDTO mascotasPropietariosDTO){
        // Buscando el MascotaPropietario por su ID
        MascotasPropietarios mascotasPropietariosExistente = mascotasPropietariosRepository.findById(id_mascota_propietario)
                .orElseThrow(()-> new MascotasPropietariosNotFoundException("Mascota-Propietario no encontrado"));
        // Obteniendo la mascota y propietario del DTO a mantener los valores existentes sino se proporcionan en el DTO
        Mascotas mascotas = mascotasPropietariosExistente.getMascotas();
        if (mascotasPropietariosDTO.getMascotasId() != null){
            mascotas = mascotaRepository.findById(mascotasPropietariosDTO.getMascotasId())
                    .orElseThrow(()-> new MascotasNotFoundException("Id de la mascota no encontrado"));
        }
        Propietarios propietarios = mascotasPropietariosExistente.getPropietarios();
        if (mascotasPropietariosDTO.getPropietariosId() != null){
            propietarios = propietariosRepository.findById(mascotasPropietariosDTO.getPropietariosId())
                    .orElseThrow(()-> new PropietariosNotFoundException("Id del propietario no encontrado"));
        }
        // Actualizando los datos del propietario con los valores del DTO
        mascotasPropietariosExistente.setEstado(mascotasPropietariosDTO.getEstado());
        mascotasPropietariosExistente.setMascotas(mascotas);
        mascotasPropietariosExistente.setPropietarios(propietarios);

        // Guardando los cambios en la base de datos usando el repositorio
        mascotasPropietariosExistente = mascotasPropietariosRepository.save(mascotasPropietariosExistente);
        return new Mascotas_PropietariosDTO(mascotasPropietariosExistente);
    }

}
