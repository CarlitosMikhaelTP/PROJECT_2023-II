package com.project.uywalky.Entity.PaseosEntitys;

import com.project.uywalky.Entity.PaseadoresEntitys.Paseadores;
import com.project.uywalky.Entity.PropietariosEntitys.Propietarios;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Calificaciones")

public class Calificaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calificacion")
    private Integer idCalificacion;

    @ManyToOne
    @JoinColumn(name = "id_paseo")
    private Paseos paseos;

    @ManyToOne
    @JoinColumn(name = "id_paseador")
    private Paseadores paseadores;

    @ManyToOne
    @JoinColumn(name = "id_propietario")
    private Propietarios propietarios;

    @Column(name = "calificacion")
    private Integer calificacion;

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

    @Override
    public String toString() {
        return "Calificaciones{" +
                "idCalificacion=" + idCalificacion +
                ", paseos=" + paseos +
                ", paseadores=" + paseadores +
                ", propietarios=" + propietarios +
                ", calificacion=" + calificacion +
                ", estado=" + estado +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                '}';
    }
}
