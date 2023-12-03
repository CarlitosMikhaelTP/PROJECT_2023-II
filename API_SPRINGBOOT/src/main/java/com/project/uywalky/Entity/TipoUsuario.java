package com.project.uywalky.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.uywalky.user.User;
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
@Table(name = "Tipos_Usuario")
// Ignora la serialización de la propiedad 'users'
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_usuario")
    private Integer idTipoUsuario;

    @Column(name = "nombre_tipo_usuario", nullable = false, length = 20, unique = true)
    private String nombreTipoUsuario;

    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;

    @Column(name = "estado", columnDefinition = "TINYINT DEFAULT 1")
    private Integer estado;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updatedAt;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoUsuario")
    private List<User> users;

    @Override
    public String toString() {
        return "TipoUsuario{" +
                "idTipoUsuario=" + idTipoUsuario +
                ", nombreTipoUsuario='" + nombreTipoUsuario + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                '}';
    }
}
