package com.project.uywalky.web.TransaccionesWeb;

import com.project.uywalky.Entity.TransaccionesEntitys.Transacciones;
import com.project.uywalky.Service.TransaccionesService;
import com.project.uywalky.Dto.TransaccionesDTO.TransaccionesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transacciones")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class TransaccionesController {

    // Inicializando el servicio de transacciones
    private  final TransaccionesService transaccionesService;

    // ENDPOINT PARA REGISTRAR TRANSACCIONES
    @PostMapping("/registrar")
    public ResponseEntity<TransaccionesDTO> registrarTransacciones(@RequestBody TransaccionesDTO transaccionesDTO){
        TransaccionesDTO transaccionRegistrado = transaccionesService.registrarTransacciones(transaccionesDTO);
        return ResponseEntity.ok(transaccionRegistrado);
    }

    // ENDPOINT PARA MOSTRAR TRANSACCIONES
    @GetMapping
    public List<Transacciones> listarTransacciones(){
        return transaccionesService.listarTransacciones();
    }

    // ENDPOINT PARA MOSTRAR UNA TRANSACCION POR SU ID
    @GetMapping("/{id}")
    public Transacciones obtenerTransacciones(@PathVariable("id") Integer id_transaccion){
        return transaccionesService.obtenerTransaccion(id_transaccion);
    }

    // ENDPOINT PARA GUARDAR NUEVAS TRANSACCIONES
    @PostMapping
    public ResponseEntity<String> guardarTransaccion(@RequestBody Transacciones transacciones){
        transaccionesService.guardarTransaccion(transacciones);
        return ResponseEntity.status(HttpStatus.CREATED).body("Transaccion guardada con éxito");
    }

    // ENDPOINT PARA ACTUALIZAR UN REGISTRO DE TRANSACCION
    @PutMapping("/{id}")
    public ResponseEntity<TransaccionesDTO> editarTransacciones(
            @PathVariable("id") Integer id,
            @RequestBody TransaccionesDTO transaccionesDTO){
        TransaccionesDTO transaccionEditada = transaccionesService.editarTransaccion(id, transaccionesDTO);
        return ResponseEntity.ok(transaccionEditada);
    }
}
