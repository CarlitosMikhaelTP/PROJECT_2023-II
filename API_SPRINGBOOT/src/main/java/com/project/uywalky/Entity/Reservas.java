package com.project.uywalky.Entity;

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
@Table(name = "Reservas")
public class Reservas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Integer idReserva;

    @ManyToOne
    @JoinColumn(name = "id_propietario")
    private Propietarios propietarios;

    @ManyToOne
    @JoinColumn(name = "id_paseador")
    private Paseadores paseadores;

    @Column(name = "costo", nullable = false)
    private Integer costo; // costo referencial

    @Column(name = "fecha_reserva", nullable = false)
    private String fecha_reserva;

    @Column(name = "hora_reserva", nullable = false)
    private String hora_reserva;

    @Column(name = "punto_encuentro", nullable = false)
    private String punto_encuentro;

    @Column(name = "duracion", nullable = false)
    private Integer duracion;

    @Column(name = "lugar_paseo", nullable = false, length = 20)
    private String lugar_paseo;

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
    @OneToOne(mappedBy = "reservas")
    private Paseos paseos;

    @Override
    public String toString() {
        return "Reservas{" +
                "idReserva=" + idReserva +
                ", propietarios=" + propietarios +
                ", paseadores=" + paseadores +
                ", costo=" + costo +
                ", fecha_reserva='" + fecha_reserva + '\'' +
                ", hora_reserva='" + hora_reserva + '\'' +
                ", punto_encuentro='" + punto_encuentro + '\'' +
                ", duracion=" + duracion +
                ", lugar_paseo='" + lugar_paseo + '\'' +
                ", estado=" + estado +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                ", paseos=" + paseos +
                '}';
    }
}
