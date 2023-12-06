package com.project.uywalky.Entity.UsuariosEntitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.uywalky.Entity.PaseadoresEntitys.Paseadores;
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


@Data // Crea los GETTERS Y SETTERS JUNTO CON EL toString
@Builder // Facilita la creación de constructores complejos en Java
@NoArgsConstructor // Genera un constructor vacío
@AllArgsConstructor // Genera un constructor con todos los campos de la entidad
@Entity // Establecemos que es una entidad o tabla de la base de datos
@Table(name="Usuarios")// Especificamos el nombre de la tabla de nuestra base de datos
public class User implements UserDetails {

    // TRATAR DESPUES DE INSERTAR ANOTACIONES JPA/HIBERNATE MAS ESPECIFICAS COMO : insertable, updatetable, precision, scale

    @Id //Identificador único de esta clase de usuario
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Especificamos que la clave de identificación sea autoincremental
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
    private String password;

    // ESTOS CAMPOS NO ME IMPORTAN POR EL MOMENTO PORQUE NO LOS USO
    ////////////////////////////////////////////////////////////////////
    @Column(name = "estado", columnDefinition = "TINYINT DEFAULT 1")
    private Integer estado;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(name = "updated_at",  columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updatedAt;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "updated_by")
    private Integer updatedBy;
    //////////////////////////////////////////////////////////////7////
    // JsonIgnore evita que ciertos campos sean serializados al convertir la entidad en JSON, especialmente si hay
    // campos sensibles o que no deben exponerse en las respuestas de la API, esto evita ciclos infinitos de serializacion
    @JsonIgnore
    // "cascade" Indica que todas las operaciones realizadas en la entidad USER se propagaran a la entidad paseadores
    // permitiendo guardar, actualizar o eliminar la entidad paseadores cuadno se realice sobre USER.
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Paseadores paseadores;


    //////////////////////// ENTENDERLO MEJOR DESPUES //////////////////////////////
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
        //Asegurarnos que no esté vencido porque debe ser true sino  no podremos conectar a nuestros usuarios
        return true;
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

    // Este método representa una cadena String de mi objeto USER , esta implementacion
    // genera una cadena que resume el estado actual del objeto USER, mostrando sus valores
    // de sus atributos. Este método es util para la depuración y registro
    // o cuando imprima el objeto

    // Si quiero personalizar la representación en cadena debo usar el DTO para no afectar la estructura
    // o lógica de mi entidad.
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", tipoUsuarioId=" + (tipoUsuario != null ? tipoUsuario.getIdTipoUsuario() : null) +
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
