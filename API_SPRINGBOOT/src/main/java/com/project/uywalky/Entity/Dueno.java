package com.project.uywalky.Entity;
import com.project.uywalky.user.User;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Dueno")
public class Dueno {
    @Id
    @GeneratedValue
    private Integer idDueno;

    @OneToOne
    @JoinColumn(name="id_user")
    private User user;

    @Column(name = "tarifa_hora")
    private Integer tarifaHora;

    @Column(name = "preferencias_paseo")
    private String preferenciasPaseo;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "calificaciones")
    private Integer calificaciones;

}
