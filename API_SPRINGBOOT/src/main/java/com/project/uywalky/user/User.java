package com.project.uywalky.user;

import com.project.uywalky.Entity.Paseadores;
import com.project.uywalky.Entity.TipoUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//Proporcionar estos detalles es importante para que Spring Security pueda funcionar adecuadamente
@Data // Crea get y setters para todos los campos
@Builder //Crea y ayuda a la cosntruccion de objetos
@NoArgsConstructor //Constructor de patrones de diseño
@AllArgsConstructor //Constructor de todos los cosntructores
@Entity //Le decimos a JAVA que esta clase representa a una entidad de nuestra base de datos
@Table(name="Usuarios")// Especificamos el nombre de la tabla de nuestra base de datos
public class User implements UserDetails {

    @Id //Identificador único de esta clase de usuario
    @GeneratedValue //Incrementará el id automáticamente
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_tipo_usuario", nullable = false)
    private TipoUsuario tipoUsuario;

    @Column(name = "nombres", nullable = false, length = 20)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 20)
    private String apellidos;

    @Column(name = "apodo", nullable = false, length = 20)
    private String apodo;

    @Column(name = "direccion", nullable = false, length = 35)
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
    private String password;

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; //Asegurarnos que no esté vencido porque debe ser true sino  no podremos conectar a nuestros usuarios
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", tipoUsuario=" + tipoUsuario +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", apodo='" + apodo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", edad=" + edad +
                ", celular='" + celular + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", estado=" + estado +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                '}';
    }
}
