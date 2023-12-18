package com.example.demo.infrastructure.web.controller;

import com.example.demo.application.exceptions.PaseadoresExceptions.NotFound.PaseadorNotFoundException;
import com.example.demo.application.exceptions.PropietariosExceptions.NotFound.PropietarioNotFoundException;
import com.example.demo.application.service.PropietariosServices.PropietarioService;
import com.example.demo.domain.entity.paseadores.Paseadores;
import com.example.demo.domain.entity.propietarios.Propietarios;
import com.example.demo.domain.repository.Propietarios.PropietarioRepository;
import com.example.demo.infrastructure.web.projection.UsuarioProjections.classBased.PropietarioDTO;
import com.example.demo.infrastructure.web.projection.UsuarioProjections.interfaceBased.closed.PropietarioProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/propietario")
@RequiredArgsConstructor
public class PropietarioController {

    private final PropietarioService propietarioService;
    private final PropietarioRepository propietarioRepository;

    // Endpoint para registrar Propietarios
    @PostMapping("/register")
    public ResponseEntity<PropietarioDTO> registrarPropietario(@RequestBody PropietarioDTO propietarioDTO){
        PropietarioDTO propietarioRegistrado = propietarioService.registrarPropietario(propietarioDTO);
        return ResponseEntity.ok(propietarioRegistrado);
    }

    // Endpoint para editar Propietarios
    @PutMapping("/edit/{id}")
    public ResponseEntity<PropietarioDTO> editarPropietario(
            @PathVariable("id") Integer id,
            @RequestBody PropietarioDTO propietarioDTO
    ){
        PropietarioDTO propietarioActualizado = propietarioService.editarPropietario(id, propietarioDTO);
        return ResponseEntity.ok(propietarioActualizado);
    }

    // Endpoint para listar a todos los propietarios usando proyecciones
    @GetMapping("/findAllPropietarios")
    public List<PropietarioProjection> obtenerPropietariosDisponibles() {
        return propietarioService.obtenerPropietariosDisponibles();
    }

    // Endpoint para listar un propietario por un ID
    @GetMapping("/findPropietarioById/{idPropietario}")
    public Optional<PropietarioProjection> findPropietarioById(@PathVariable Integer idPropietario){
        return propietarioService.findPropietariosByIdPropietario(idPropietario);
    }

    // Endpoint para eliminar un propietario por un ID
    @DeleteMapping("/delete/{idPropietario}")
    public ResponseEntity<String> deletePropietarioById(@PathVariable("idPropietario") Integer idPropietario){
        boolean deleted = propietarioService.deletePropietarioById(idPropietario);

        if (deleted){
            return ResponseEntity.ok("Propietario eliminado exitosamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo encontrar el propietario a eliminar");
        }
    }

    @PostMapping("/{idPropietario}/foto")
    public ResponseEntity<String> subirFotoPropietario(
            @PathVariable Integer idPropietario,
            @RequestParam("foto") MultipartFile foto) {
        try {
            propietarioService.actualizarFotoPropietario(idPropietario, foto);
            return ResponseEntity.ok("Foto del propietario actualizada exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar la foto del propietario: " + e.getMessage());
        }
    }

    @GetMapping("/foto/{idPropietario}")
    public ResponseEntity<Resource> obtenerFotoPropietario(@PathVariable Integer idPropietario) {
        Propietarios propietario = propietarioRepository.findById(idPropietario)
                .orElseThrow(() -> new PropietarioNotFoundException("Propietario no encontrado"));

        String rutaFoto = propietario.getFoto();

        // Cargar el archivo de la ruta
        Path filePath = Paths.get(rutaFoto);
        Resource resource = null;

        try {
            resource = new UrlResource(filePath.toUri());
            if (resource.exists() && resource.isReadable()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG) // Cambiar el tipo MIME según el tipo de archivo
                        .body(resource);
            } else {
                throw new FileNotFoundException("No se pudo encontrar o leer la imagen del paseador");
            }
        } catch (MalformedURLException | FileNotFoundException e) {
            // Manejo de excepciones si el archivo no se encuentra o no se puede leer
            // Devolver un error o un recurso vacío en la respuesta
            return ResponseEntity.notFound().build();
        }
    }
}

