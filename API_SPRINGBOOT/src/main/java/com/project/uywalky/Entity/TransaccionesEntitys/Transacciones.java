package com.project.uywalky.Entity.TransaccionesEntitys;


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
@Table(name = "Transacciones")
public class Transacciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaccion")
    private Integer id_transaccion;

    @ManyToOne
    @JoinColumn(name = "id_paseador")
    private Paseadores paseadores;

    @ManyToOne
    @JoinColumn(name = "id_propietario")
    private Propietarios propietarios;

    @ManyToOne
    @JoinColumn(name = "id_tipo_transaccion")
    private TiposTransaccion tiposTransaccion;

    @ManyToOne
    @JoinColumn(name = "id_estado_transaccion")
    private EstadoTransaccion estadoTransaccion;

    @Column(name = "monto", nullable = false)
    private Integer monto;

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
        return "Transacciones{" +
                "id_transaccion=" + id_transaccion +
                ", paseadores=" + paseadores +
                ", propietarios=" + propietarios +
                ", tiposTransaccion=" + tiposTransaccion +
                ", estadoTransaccion=" + estadoTransaccion +
                ", monto=" + monto +
                ", estado=" + estado +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                '}';
    }
}
