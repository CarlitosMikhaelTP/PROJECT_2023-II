package com.example.demo.domain.entity.paseadores;

import com.example.demo.domain.entity.paseos.Reservas;
import com.example.demo.domain.entity.transacciones.Transacciones;
import com.example.demo.domain.entity.usuarios.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
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
    private Integer idPaseador;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categorias categorias;

    @Column(name = "calificacion", nullable = false)
    private Integer calificacion;

    @Column(name = "descripcion", columnDefinition = "TEXT", nullable = false)
    private String descripcion;

    @Column(name = "experiencia", columnDefinition = "TEXT")
    private String experiencia;

    @Column(name = "ubicacion", length = 20, nullable = false)
    private String ubicacion;

    @Column(name = "tarifa", precision = 10, scale = 2, nullable = false)
    private BigDecimal tarifa;

    @Column(name = "saldo", precision = 10, scale = 2, nullable = false)
    private BigDecimal saldo;

    @Column(name = "disponibilidad", nullable = false)
    private Boolean disponibilidad;

    @Lob
    @Column(name = "foto", nullable = false)
    private byte[] foto;

    @Column(name = "estado", columnDefinition = "TINYINT DEFAULT 1")
    private Short estado;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private User createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by", referencedColumnName = "id")
    private User updatedBy;

    //////////// MAPEO DE CARDINALIDADES ////////////////////////
    @OneToMany(mappedBy = "paseadores", cascade = CascadeType.ALL)
    private List<Transacciones> transacciones;

    @OneToMany(mappedBy = "paseadores", cascade = CascadeType.ALL)
    private List<Reservas> reservas;

    @OneToOne(mappedBy = "paseadores", cascade = CascadeType.ALL)
    private LocacionPaseador locacionPaseador;
}
