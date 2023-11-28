package com.project.uywalky.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data // Permite establecer la cardindaliad con anotaciones
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Categoria")
public class Categorias {
    @Id
    @GeneratedValue
    @Column(name = "id_categoria")
    private Integer id_categoria;

    @Column(name = "categoria_nombre", nullable = false, length = 20)
    private String categoria_nombre;

    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;

    @Column(name = "estado", columnDefinition = "TINYINT DEFAULT 1")//Despues agregar opcion para que no sea nulo
    private Integer estado;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(name = "updated_at",  columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updatedAt;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @JsonIgnore
    @OneToMany(mappedBy = "categorias")
    private List<Paseadores> paseadores;

    @Override
    public String toString() {
        return "Categorias{" +
                "id_categoria=" + id_categoria +
                ", categoria_nombre='" + categoria_nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                ", paseadores=" + paseadores +
                '}';
    }
}
