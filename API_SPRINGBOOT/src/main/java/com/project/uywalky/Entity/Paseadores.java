package com.project.uywalky.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.uywalky.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.Text;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Paseadores")
public class Paseadores {

    // Id del paseador
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paseador")
    private Integer id_paseador;

    // Id de usuario del paseador
    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private User user; //id del usuario

    // Id de la categoria del paseador
    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categorias categorias;

    @Column(name = "calificacion", nullable = false)
    private Integer calificacion;

    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;

    @Column(name = "experiencia", length = 255)
    private String experiencia;

    @Column(name = "ubicacion", nullable = false)
    private Integer ubicacion;

    @Column(name = "tarifa", nullable = false)
    private Integer tarifa;

    @Column(name = "saldo")
    private Integer saldo;

    @Column(name = "disponibilidad")
    private Integer disponibilidad;

    @Column(name = "foto", nullable = false, length = 3)
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
    @OneToMany(mappedBy = "paseadores")
    private List<Transacciones> transacciones;

    @JsonIgnore
    @OneToMany(mappedBy = "paseadores")
    private List<Paseos> paseos;

    @JsonIgnore
    @OneToMany(mappedBy = "paseadores")
    private List<Calificaciones> calificaciones;

    @JsonIgnore
    @OneToOne(mappedBy = "paseadores")
    private Ubicaciones ubicaciones;

    @JsonIgnore
    @OneToMany(mappedBy = "paseadores")
    private List<Reservas> reservas;

    @JsonIgnore
    @OneToOne(mappedBy = "paseadores")
    private LocacionPaseador locacionPaseador;


    @Override
    public String toString() {
        return "Paseadores{" +
                "id_paseador=" + id_paseador +
                ", userId=" + (user != null ? user.getId() : null) +
                ", categoriasId=" + (categorias != null ? categorias.getId_categoria() : null)+
                ", calificacion=" + calificacion +
                ", descripcion='" + descripcion + '\'' +
                ", experiencia='" + experiencia + '\'' +
                ", ubicacion=" + ubicacion +
                ", tarifa=" + tarifa +
                ", saldo=" + saldo +
                ", disponibilidad=" + disponibilidad +
                ", foto='" + foto + '\'' +
                ", estado=" + estado +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                '}';
    }
}
