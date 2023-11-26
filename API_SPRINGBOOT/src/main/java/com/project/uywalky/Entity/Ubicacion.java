package com.project.uywalky.Entity;

import com.project.uywalky.user.User;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;

import javax.lang.model.element.Name;
import java.awt.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Ubicacion")
public class Ubicacion {
    @Id
    @GeneratedValue
    private Integer idUbicacion;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_paseador")
    private Paseadores paseadores;

    @ManyToOne
    @JoinColumn(name = "id_mascota")
    private Mascota mascota;

    private String puntoEncuentro;
    private Integer ubicacionUsuario;
    private Integer ubicacionPaseador;
    private Integer estado;
}
