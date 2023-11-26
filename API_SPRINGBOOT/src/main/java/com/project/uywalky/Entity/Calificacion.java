package com.project.uywalky.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Calificacion")

public class Calificacion {

    @Id
    @GeneratedValue
    @Column(name = "id_calificacion")
    private Integer idCalificacion;

    @ManyToOne
    @JoinColumn(name = "id_paseo")
    private Paseo paseo;

    @ManyToOne
    @JoinColumn(name = "id_dueno")
    private Dueno dueno;

    @ManyToOne
    @JoinColumn(name = "id_paseador")
    private Paseadores paseadores;

    @Column(name = "calificacion")
    private Integer calificacion;

    @Column(name = "estado")
    private Integer estado;

}
