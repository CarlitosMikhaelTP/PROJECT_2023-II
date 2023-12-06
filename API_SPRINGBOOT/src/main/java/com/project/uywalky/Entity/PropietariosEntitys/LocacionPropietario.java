package com.project.uywalky.Entity.PropietariosEntitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Locacion_Propietario")

public class LocacionPropietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_locacion_propietario")
    private Integer id_locacion_propietario;

    @OneToOne
    @JoinColumn(name = "id_propietario", nullable = false)
    private Propietarios propietarios;

    @Column(name ="latitud")
    private BigDecimal latitud;

    @Column(name = "longitud")
    private BigDecimal longitud;

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
        return "LocacionPropietario{" +
                "id_locacion_propietario=" + id_locacion_propietario +
                ", propietarios=" + propietarios +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", estado=" + estado +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                '}';
    }
}
