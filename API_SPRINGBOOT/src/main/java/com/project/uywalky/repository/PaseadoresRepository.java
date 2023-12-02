package com.project.uywalky.repository;

import com.project.uywalky.Entity.Paseadores;
import com.project.uywalky.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaseadoresRepository extends JpaRepository<Paseadores, Integer> {
    // Definiendo método para verificar existencia de un usuario con cuenta de Paseador
    boolean existsByUser(User user);
}
