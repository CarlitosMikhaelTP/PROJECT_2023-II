package com.example.demo.domain.entity.propietariosEntitys;

import com.example.demo.domain.entity.mascotasEntitys.MascotasPropietarios;
import com.example.demo.domain.entity.paseosEntitys.Reservas;
import com.example.demo.domain.entity.transaccionesEntitys.Transacciones;
import com.example.demo.domain.entity.usuariosEntitys.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Propietarios")
public class Propietarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_propietario")
    private Integer idPropietario;

    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private User user;

    @Column(name = "calificacion")
    private Integer calificacion;

    @Column(name = "comentario", columnDefinition = "TEXT", nullable = false)
    private String comentario;

    @Column(name = "preferencias_paseo", columnDefinition = "TEXT", nullable = false)
    private String preferenciasPaseo;

    @Column(name = "saldo", precision = 10, scale = 2, nullable = false)
    private BigDecimal saldo;

    @Column(name = "disponibilidad", nullable = false)
    private Boolean disponibilidad;

    @Column(name = "ubicacion", length = 20, nullable = false)
    private String ubicacion;

    @Lob
    @Column(name = "foto", nullable = false)
    private byte[] foto;

    @Column(name = "estado", columnDefinition = "TINYINT DEFAULT 1")
    private Short estado;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(name = "updated_at",  columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private User createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by", referencedColumnName = "id")
    private User updatedBy;

    ///////// MAPEO DE CARDINALIDADES ////////////////////////////
    @OneToMany(mappedBy = "propietarios")
    private List<Transacciones> transacciones;

    @OneToMany(mappedBy = "propietarios", cascade = CascadeType.ALL)
    private List<MascotasPropietarios> mascotasPropietarios;

    @OneToMany(mappedBy = "propietarios", cascade = CascadeType.ALL)
    private List<Reservas> reservas;

    @OneToOne(mappedBy = "propietarios", cascade = CascadeType.ALL)
    private LocacionPropietario locacionPropietario;
}
