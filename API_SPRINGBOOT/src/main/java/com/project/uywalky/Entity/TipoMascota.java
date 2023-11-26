package com.project.uywalky.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.message.StringFormattedMessage;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TipoMascota")
public class TipoMascota {

    @Id
    @GeneratedValue
    private Integer idTipoMascota;

    private String nombre;

    private Integer estado;

    @OneToMany(mappedBy = "tipoMascota")
    private List<Mascota> mascotas;
}
