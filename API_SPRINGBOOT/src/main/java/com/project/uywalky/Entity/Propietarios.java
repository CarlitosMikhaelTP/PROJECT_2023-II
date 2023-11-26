package com.project.uywalky.Entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="MascotaDueno")

public class Propietarios {
    @Id
    @Generated
    private Integer idMascotaDueno;

    @ManyToOne
    @JoinColumn(name = "id_dueno")
    private Dueno dueno;

    @ManyToOne
    @JoinColumn(name = "id_mascota")
    private Mascota mascota;

    private Integer estado;
}
