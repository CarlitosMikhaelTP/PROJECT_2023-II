package com.project.uywalky.Repository.PaseadoresRepo;

import com.project.uywalky.Entity.PaseadoresEntitys.Paseadores;
import com.project.uywalky.Entity.UsuariosEntitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaseadoresRepository extends JpaRepository<Paseadores, Integer> {
    // Definiendo método para verificar existencia de un usuario con cuenta de Paseador
    boolean existsByUser(User user);
}
