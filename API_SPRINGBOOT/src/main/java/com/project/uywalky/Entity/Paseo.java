package com.project.uywalky.Entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Paseos")
public class Paseo {

    @Id
    @GeneratedValue
    private Integer idPaseo;

    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "id_mascota")
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "id_paseador")
    private Paseadores paseadores;

    private Integer horaPaseo;
    private Integer duracion;
    private String ubicacion;
    private Integer estado;
}
