package com.example.demo.domain.entity.usuariosEntitys;

import com.example.demo.domain.entity.paseadoresEntitys.Paseadores;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_usuario", nullable = false)
    private TiposUsuario tiposUsuario;

    @Column(name = "nombres", nullable = false, length = 20)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 20)
    private String apellidos;

    @Column(name = "apodo", nullable = false, length = 20)
    private String apodo;

    @Column(name = "direccion", nullable = false, length = 20)
    private String direccion;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name = "celular", nullable = false, length = 9, unique = true)
    private String celular;

    @Column(name = "dni", nullable = false, length = 8, unique = true)
    private String dni;

    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String  password;

    @Column(name = "estado", columnDefinition = "TYNI DEFAULT 1")
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

    /////////// MAPEANDO CARDINALIDAD ////////////////////////////
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Paseadores paseadores;

}
