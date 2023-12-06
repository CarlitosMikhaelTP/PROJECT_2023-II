package com.project.uywalky.Entity.MascotasEntitys;

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
@Table(name ="Mascotas_Propietarios")
public class MascotasPropietarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota_propietario")
    private Integer id_mascota_propietario;

    @ManyToOne
    @JoinColumn(name = "id_propietario")
    private Propietarios propietarios;

    @ManyToOne
    @JoinColumn(name = "id_mascota")
    private Mascotas mascotas;

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
        return "MascotasPropietarios{" +
                "id_mascota_propietario=" + id_mascota_propietario +
                ", propietarios=" + propietarios +
                ", mascotas=" + mascotas +
                ", estado=" + estado +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                '}';
    }
}
