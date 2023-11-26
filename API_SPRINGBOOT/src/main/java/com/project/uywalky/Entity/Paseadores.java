package com.project.uywalky.Entity;


import com.project.uywalky.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.Text;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "paseadores")

public class Paseadores {

    @Id
    @GeneratedValue
    private Integer id_paseador;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private User user; //id del usuario

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @Column(name = "experiencia")
    private String experiencia;

    @Column(name = "tarifa_hora")
    private Integer tarifa_hora;

    @Column(name = "disponibilidad")
    private Integer disponibilidad;

    @Column(name = "calificaciones")
    private Integer calificaciones;

    @Column(name = "comentarios")
    private String comentarios;

    @Override
    public String toString() {
        return "Paseadores{" +
                "id_paseador=" + id_paseador +
                ", user=" + user +
                ", categoria=" + categoria +
                ", experiencia='" + experiencia + '\'' +
                ", tarifa_hora=" + tarifa_hora +
                ", disponibilidad=" + disponibilidad +
                ", calificaciones=" + calificaciones +
                ", comentarios='" + comentarios + '\'' +
                '}';
    }
}
