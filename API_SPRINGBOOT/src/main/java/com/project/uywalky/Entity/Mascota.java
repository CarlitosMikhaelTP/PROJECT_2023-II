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
@Table(name = "Mascota")
public class Mascota {

    @Id
    @GeneratedValue
    private Integer idMascota;

    @ManyToOne
    @JoinColumn(name = "Id_tipo_mascota")
    private TipoMascota tipoMascota;

    private String nombre;
    private String raza;
    private Integer edad;
    private String necesidades;
    private Integer estado;

    @OneToMany(mappedBy = "mascota")
    private List<Propietarios> duenos;

    @OneToMany(mappedBy = "mascota")
    private List<Paseo> paseos;

    @OneToMany(mappedBy = "mascota")
    private List<Reserva> reservas;
}
