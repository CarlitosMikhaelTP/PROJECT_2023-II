package com.project.uywalky.web.PaseoWeb;

import com.project.uywalky.Entity.PaseosEntitys.Reservas;
import com.project.uywalky.Service.ReservaService;
import com.project.uywalky.Dto.PaseosDTO.ReservasDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reserva")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ReservaController {

    private final ReservaService reservaService;

    // ENDPOINT PARA REGISTRAR RESERVAS
    @PostMapping("/registrar")
    public ResponseEntity<ReservasDTO> registrarReservas(@RequestBody ReservasDTO reservasDTO){
        ReservasDTO reservaRegistrada = reservaService.registrarReservas(reservasDTO);
        return ResponseEntity.ok(reservaRegistrada);
    }

    // ENDPOINT PARA MOSTRAR LISTA DE RESERVAS
    @GetMapping
    public List<Reservas> listarReservas(){
        return reservaService.listarReservas();
    }

    // ENDPOINT PARA MOSTRAR AL PROPIETARIO POR ID
    @GetMapping("/{id}")
    public Reservas obtenerReservas(@PathVariable("id") Integer id_reserva){
        return reservaService.obtenerReserva(id_reserva);
    }

    // ENDPOINT PARA GUARDAR UNA RESERVA
    @PostMapping
    public ResponseEntity<String> guardarReserva(@RequestBody Reservas reservas){
        reservaService.guardarReserva(reservas);
        return ResponseEntity.status(HttpStatus.CREATED).body("Reserva guardada exitósamente");
    }

    // ENDPOINT PARA ELIMINAR UNA RESERVA POR ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarReserva(@PathVariable("id") Integer id_reserva){
        reservaService.eiminarReserva(id_reserva);
        return ResponseEntity.status(HttpStatus.OK).body("Reserva eliminada correctamente");
    }

    // ENDPOITN PARA ELIMINAR UNA RESERVA POR SU ID
    @PutMapping("/{id}")
    public ResponseEntity<ReservasDTO> editarReserva(
            @PathVariable("id") Integer id,
            @RequestBody ReservasDTO reservasDTO){
        ReservasDTO reservaEditada = reservaService.editarReserva(id, reservasDTO);
        return ResponseEntity.ok(reservaEditada);
    }
}
