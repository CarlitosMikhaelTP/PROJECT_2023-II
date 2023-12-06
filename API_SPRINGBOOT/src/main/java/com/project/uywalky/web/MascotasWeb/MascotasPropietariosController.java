package com.project.uywalky.web.MascotasWeb;

import com.project.uywalky.Entity.MascotasEntitys.MascotasPropietarios;
import com.project.uywalky.Service.MascotasPropietariosService;
import com.project.uywalky.Dto.MascotasDTO.Mascotas_PropietariosDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/intermedia")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class MascotasPropietariosController {

    private final MascotasPropietariosService mascotasPropietariosService;

    // ENDPOINT para registrar
    @PostMapping("/registrar")
    public ResponseEntity<Mascotas_PropietariosDTO> registrarMascotasPropietarios(@RequestBody Mascotas_PropietariosDTO mascotasPropietariosDTO){
        Mascotas_PropietariosDTO mascotasPropietariosRegistrado = mascotasPropietariosService.registrarMascotasPropietarios(mascotasPropietariosDTO);
        return ResponseEntity.ok(mascotasPropietariosRegistrado);
    }

    // ENDPOINT para mostrar la lista de registros
    @GetMapping
    public List<MascotasPropietarios> listarMascotasPropietarios(){
        return mascotasPropietariosService.listarMascotasPropietarios();
    }

    // ENDPOINT para mostrar por ID
    @GetMapping("/{id}")
    public MascotasPropietarios obtenerMascotasPropietarios(@PathVariable("id") Integer id_mascota_propietario){
        return mascotasPropietariosService.obtenerMascotasPropietarios(id_mascota_propietario);
    }

    // ENDPOINT para guardar nuevos registros
    @PostMapping
    public ResponseEntity<String> guardarMascotasPropietarios(@RequestBody MascotasPropietarios mascotasPropietarios){
        mascotasPropietariosService.guardarMascotasPropietarios(mascotasPropietarios);
        return ResponseEntity.status(HttpStatus.CREATED).body("MascotaPropietario guardado correctamente");
    }

    // ENDPOINT para eliminar por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarMascotasPropietarios(@PathVariable("id") Integer id_mascota_propietario){
        mascotasPropietariosService.eliminarMascotasPropietarios(id_mascota_propietario);
        return ResponseEntity.status(HttpStatus.OK).body("MascotaPropietario eliminado correctamente");
    }

    // ENDPOINT para editar
    @PutMapping("/{id}")
    public ResponseEntity<Mascotas_PropietariosDTO> editarMascotaPropietario(
            @PathVariable("id") Integer id,
            @RequestBody Mascotas_PropietariosDTO mascotasPropietariosDTO){
        Mascotas_PropietariosDTO mascotaPropietarioEditado = mascotasPropietariosService.editarMascotaPropietario(id, mascotasPropietariosDTO);
        return ResponseEntity.ok(mascotaPropietarioEditado);
    }
}
