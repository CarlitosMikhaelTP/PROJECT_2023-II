package com.project.uywalky.Entity.MascotasEntitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.uywalky.Entity.PropietariosEntitys.Propietarios;
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
@Table(name = "Mascotas")
public class Mascotas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private Integer id_mascota;

    @ManyToOne
    @JoinColumn(name = "Id_tipo_mascota")
    private TipoMascota tipoMascota;

    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;

    @Column(name = "raza", nullable = false, length = 20)
    private String raza;

    @Column(name = "peso", nullable = false, length = 20)
    private String peso;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name = "foto", nullable = false)
    private Integer foto;

    @Column(name = "necesidades", nullable = false)
    private String necesidades;

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
    @OneToMany(mappedBy = "mascotas")
    private List<Propietarios> propietarios;

    @JsonIgnore
    @OneToMany(mappedBy = "mascotas", cascade = CascadeType.ALL)
    private List<MascotasPropietarios> mascotasPropietarios;

    @Override
    public String toString() {
        return "Mascotas{" +
                "idMascota=" + id_mascota +
                ", tipoMascotaId=" + (tipoMascota != null ? tipoMascota.getIdTipoMascota() : null) +
                ", nombre='" + nombre + '\'' +
                ", raza='" + raza + '\'' +
                ", peso='" + peso + '\'' +
                ", edad=" + edad +
                ", foto=" + foto +
                ", necesidades='" + necesidades + '\'' +
                ", estado=" + estado +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                ", propietarios=" + propietarios +
                ", mascotasPropietarios=" + mascotasPropietarios +
                '}';
    }
}
