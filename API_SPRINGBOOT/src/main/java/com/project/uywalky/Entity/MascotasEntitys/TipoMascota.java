package com.project.uywalky.Entity.MascotasEntitys;

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
@Table(name = "Tipos_Mascota")
public class TipoMascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_mascota")
    private Integer idTipoMascota;

    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;

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
    @OneToMany(mappedBy = "tipoMascota")
    private List<Mascotas> mascotas;

    @Override
    public String toString() {
        return "TipoMascota{" +
                "idTipoMascota=" + idTipoMascota +
                ", nombre='" + nombre + '\'' +
                ", estado=" + estado +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                ", mascotas=" + mascotas +
                '}';
    }
}
