package com.project.uywalky.Repository.PropietariosRepo;

import com.project.uywalky.Entity.PropietariosEntitys.Propietarios;
import com.project.uywalky.Entity.UsuariosEntitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropietariosRepository extends JpaRepository<Propietarios, Integer> {
    // Definiendo método para verificar existencia de un usuario
    boolean existsByUser(User user);
}
