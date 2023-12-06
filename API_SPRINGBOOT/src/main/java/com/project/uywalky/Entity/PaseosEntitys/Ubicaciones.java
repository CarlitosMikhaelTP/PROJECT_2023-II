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
@Table(name = "Ubicaciones")
public class Ubicaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ubicacion")
    private Integer id_ubicacion;

    @OneToOne
    @JoinColumn(name = "id_paseador")
    private Paseadores paseadores;

    @OneToOne
    @JoinColumn(name = "id_propietario")
    private Propietarios propietarios;

    @OneToOne
    @JoinColumn(name = "id_paseo")
    private Paseos paseos;

    @Column(name = "latitud_paseador")
    private Integer latitud_paseador;

    @Column(name = "longitud_paseador")
    private Integer longitud_paseador;

    @Column(name = "latitud_propietaio")
    private Integer latitud_propietario;

    @Column(name = "longitud_propietario")
    private Integer longitud_propietario;

    @Column(name = "nombre_ubicacion", nullable = false, length = 20)
    private String nombre_ubicacion;

    @Column(name = "ubicacion_propietario")
    private Integer ubicacion_propietario;

    @Column(name = "ubicacion_paseador")
    private Integer ubicacion_paseador;

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
        return "Ubicaciones{" +
                "id_ubicacion=" + id_ubicacion +
                ", paseadores=" + paseadores +
                ", propietarios=" + propietarios +
                ", paseos=" + paseos +
                ", latitud_paseador=" + latitud_paseador +
                ", longitud_paseador=" + longitud_paseador +
                ", latitud_propietario=" + latitud_propietario +
                ", longitud_propietario=" + longitud_propietario +
                ", nombre_ubicacion='" + nombre_ubicacion + '\'' +
                ", ubicacion_propietario=" + ubicacion_propietario +
                ", ubicacion_paseador=" + ubicacion_paseador +
                ", estado=" + estado +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                '}';
    }
}
