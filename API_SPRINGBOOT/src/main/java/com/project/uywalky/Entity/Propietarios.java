package com.project.uywalky.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.uywalky.user.User;
import jakarta.persistence.*;
import lombok.*;

import javax.lang.model.element.Name;
import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Propietarios")
public class Propietarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_propietario")
    private Integer id_propietario;

    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_mascota", nullable = false)
    private Mascotas mascotas;

    @Column(name = "calificacion")
    private Integer calificacion;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "proferencias_paseo")
    private String preferencias_paseo;

    @Column(name = "saldo")
    private Integer saldo;

    @Column(name = "disponibilidad")
    private Integer disponibilidad;

    @Column(name = "ubicacion")
    private Integer ubicacion;

    @Column(name = "foto", length = 3)
    private String foto;

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
    @OneToMany(mappedBy = "propietarios")
    private List<Transacciones> transacciones;

    @JsonIgnore
    @OneToMany(mappedBy = "propietarios", cascade = CascadeType.ALL)
    private List<MascotasPropietarios> mascotasPropietarios;

    @JsonIgnore
    @OneToMany(mappedBy = "propietarios", cascade = CascadeType.ALL)
    private List<Paseos> paseos;

    @JsonIgnore
    @OneToMany(mappedBy = "propietarios", cascade = CascadeType.ALL)
    private List<Comentarios> comentarios;

    @JsonIgnore
    @OneToMany(mappedBy = "propietarios", cascade = CascadeType.ALL)
    private List<Calificaciones> calificaciones;

    @JsonIgnore
    @OneToOne(mappedBy = "propietarios")
    private Ubicaciones ubicaciones;

    @JsonIgnore
    @OneToMany(mappedBy = "propietarios")
    private List<Reservas> reservas;

    @Override
    public String toString() {
        return "Propietarios{" +
                "id_propietario=" + id_propietario +
                ", userId=" + (user != null ? user.getId() : null)  +
                ", mascotasId=" + (mascotas != null ? mascotas.getId_mascota() : null)  +
                ", calificacion=" + calificacion +
                ", comentario='" + comentario + '\'' +
                ", preferencias_paseo='" + preferencias_paseo + '\'' +
                ", saldo=" + saldo +
                ", disponibilidad=" + disponibilidad +
                ", ubicacion=" + ubicacion +
                ", foto='" + foto + '\'' +
                ", estado=" + estado +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                ", transacciones=" + transacciones +
                ", mascotasPropietarios=" + mascotasPropietarios +
                '}';
    }
}
