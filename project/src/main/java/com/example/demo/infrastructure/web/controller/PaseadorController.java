package com.example.demo.infrastructure.web.controller;

import com.example.demo.application.exceptions.PaseadoresExceptions.NotFound.PaseadorNotFoundException;
import com.example.demo.application.service.PaseadoresServices.PaseadorService;

import com.example.demo.domain.entity.paseadores.Paseadores;
import com.example.demo.domain.repository.Paseadores.PaseadorRepository;
import com.example.demo.infrastructure.web.projection.UsuarioProjections.classBased.PaseadoresDTO;
import com.example.demo.infrastructure.web.projection.UsuarioProjections.interfaceBased.closed.PaseadorProjection;

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
@RequestMapping("/api/v1/paseador")
@RequiredArgsConstructor
public class PaseadorController {

    // Inicializamos las clases para trabajar con este constructor con "final"
    private final PaseadorService paseadorService;
    private final PaseadorRepository paseadorRepository;

    // Endpoint para registrar Paseadores
    @PostMapping("/register")
    public ResponseEntity<PaseadoresDTO> registrarPaseador(
            @RequestBody PaseadoresDTO paseadoresDTO) {
        PaseadoresDTO paseadorRegistrado = paseadorService.registrarPaseador(paseadoresDTO);
        return ResponseEntity.ok().body(paseadorRegistrado);
    }

    // Endpoint para editar Paseadores
    @PutMapping("/edit/{id}")
    public ResponseEntity<PaseadoresDTO> editarPaseador(
            @PathVariable("id") Integer id,
            @RequestBody PaseadoresDTO paseadoresDTO
    ) {
        PaseadoresDTO paseadorActualizado = paseadorService.editarPaseador(id, paseadoresDTO);
        return ResponseEntity.ok(paseadorActualizado);
    }

    // Endpoint para listar a todos los paseadores usando proyecciones
    @GetMapping("/findAllPaseadores")
    public List<PaseadorProjection> findAllPaseadores() {
        return paseadorService.findBy(); // Obtiene todos los paseadores con la proyección
    }

    // Endpoint para listar un paseador por su ID
    @GetMapping("/findPaseadorById/{idPaseador}")
    public Optional<PaseadorProjection> findPaseadorById(@PathVariable Integer idPaseador) {
        return paseadorService.findPaseadoresByIdPaseador(idPaseador);
    }

    // Endpoint para eliminar un paseador por su ID
    @DeleteMapping("/delete/{idPaseador}")
    public ResponseEntity<String> deletePaseadorById(@PathVariable("idPaseador") Integer idPaseador) {
        boolean deleted = paseadorService.deletePaseadorById(idPaseador);

        if (deleted) {
            return ResponseEntity.ok("Paseador eliminado exitosamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo encontrar el paseador a eliminar");
        }
    }

    @PostMapping("/{idPaseador}/foto")
    public ResponseEntity<String> subirFotoPaseador(
            @PathVariable Integer idPaseador,
            @RequestParam("foto") MultipartFile foto) {
        try {
            paseadorService.actualizarFotoPaseador(idPaseador, foto);
            return ResponseEntity.ok("Foto del paseador actualizada exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar la foto del paseador: " + e.getMessage());
        }
    }

    @GetMapping("/foto/{idPaseador}")
    public ResponseEntity<Resource> obtenerFotoPaseador(@PathVariable Integer idPaseador) {
        Paseadores paseador = paseadorRepository.findById(idPaseador)
                .orElseThrow(() -> new PaseadorNotFoundException("Paseador no encontrado"));

        String rutaFoto = paseador.getFoto();

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
    // Creacón de los ENDPOINTS
    // ENDPOINT PARA REGISTRAR NUEVOS PASEADORES

