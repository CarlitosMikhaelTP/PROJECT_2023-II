package com.project.uywalky.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Reservas")
public class Reserva {
    @Id
    @GeneratedValue
    private Integer idReserva;

    @ManyToOne
    @JoinColumn(name = "id_dueno")
    private Dueno dueno;

    @ManyToOne
    @JoinColumn(name = "id_mascota")
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "id_paseador")
    private Paseadores paseadores;

    private Integer fechaSolicitud;

    private String ubicacion;

    private Integer estado;

    @OneToMany(mappedBy = "reserva")
    private List<Paseo> paseos;

}
