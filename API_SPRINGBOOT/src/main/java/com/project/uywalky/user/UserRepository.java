package com.project.uywalky.user;

//Interfaz  responsable de comunicarse con la base de datos

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

//Para convertir esta clase en repositorio solo debemos extender JpaRepository
public interface UserRepository extends JpaRepository<User, Integer> {
    //Todo esto contiene método propios para buscar un ID por ejemplo
    // Método encargado de buscar y traer un usuario por su correo electrónico porque es único
    @EntityGraph(attributePaths = "tipoUsuario") // Carga explícitamente el TipoUsuario
    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.tipoUsuario WHERE u.id = :id")
    User loadTipoUsuario(@Param("id") Integer id);
}

