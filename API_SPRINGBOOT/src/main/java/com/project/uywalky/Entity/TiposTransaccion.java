package com.project.uywalky.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Tipos_Transaccion")
public class TiposTransaccion {

    @Id
    @GeneratedValue
    @Column(name = "id_tipo_transaccion")
    private Integer id_tipo_transaccion;

    @Column(name = "nombre_tipo", nullable = false, length = 20)
    private String nombre_tipo;

    @Column(name = "descripcion", nullable = false)
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
    @OneToMany(mappedBy = "tiposTransaccion")
    private List<Transacciones> transacciones;

    @Override
    public String toString() {
        return "TiposTransaccion{" +
                "id_tipo_transaccion=" + id_tipo_transaccion +
                ", nombre_tipo='" + nombre_tipo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                ", transacciones=" + transacciones +
                '}';
    }
}
