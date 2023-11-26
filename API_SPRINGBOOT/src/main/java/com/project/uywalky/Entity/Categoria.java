package com.project.uywalky.Entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Categoria")
public class Categoria {
    @Id
    @GeneratedValue
    private Integer idCategoria;
    private String nombreCategoria;
    private String descripcion;
    private Integer estado;

    @OneToMany(mappedBy = "categoria")
    private List<Paseadores> paseadores;
}
