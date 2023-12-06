package com.project.uywalky.Entity.TransaccionesEntitys;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Estados_Transaccion")
public class EstadoTransaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_transaccion")
    private Integer id_estado_transaccion;

    @Column(name = "nombre_estado")
    private String nombre_estado;

    @Column(name = "descripcion")
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
    @OneToMany(mappedBy = "estadoTransaccion")
    private List<Transacciones> transacciones;
    @Override
    public String toString() {
        return "EstadoTransaccion{" +
                "id_estado_transaccion=" + id_estado_transaccion +
                ", nombre_estado='" + nombre_estado + '\'' +
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
