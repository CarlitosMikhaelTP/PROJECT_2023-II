package com.example.demo.domain.repository.UsuariosRepos;

import com.example.demo.domain.entity.usuariosEntitys.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>{

        // Método para buscar un usuario por su email
        // Carga explícitament el tipo de usuario
        @EntityGraph(attributePaths = "tiposUsuario")
        Optional<User> findByEmail(String email);

        // Método para mostrar el id del tipo de usuario de un usuario
        @Query("SELECT u FROM User u LEFT JOIN FETCH u.tiposUsuario WHERE u.id = :id")
        User loadTipoUsuario(@Param("id") Integer id);
}
