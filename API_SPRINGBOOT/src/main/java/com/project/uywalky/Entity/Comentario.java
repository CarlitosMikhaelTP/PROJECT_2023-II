package com.project.uywalky.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Comentario")

public class Comentario {

    @Id
    @GeneratedValue
    private Integer idComentario;

    @ManyToOne
    @JoinColumn(name = "id_paseo")
    private Paseo paseo;

    @ManyToOne
    @JoinColumn(name = "id_dueno")
    private Dueno dueno;

    @ManyToOne
    @JoinColumn(name = "id_paseador")
    private Paseadores paseadores;

    @Column(name = "comentario_usuario")
    private String comentarioUsuario;

    @Column(name = "comentario_dueno")
    private String comentarioDueno;

    @Column(name = "estado")
    private Integer estado;
}
