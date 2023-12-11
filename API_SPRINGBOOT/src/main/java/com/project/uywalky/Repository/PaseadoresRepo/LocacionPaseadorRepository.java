package com.project.uywalky.Repository.PaseadoresRepo;

import com.project.uywalky.Entity.PaseadoresEntitys.LocacionPaseador;
import com.project.uywalky.Entity.PaseadoresEntitys.Paseadores;
import com.project.uywalky.Entity.UsuariosEntitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public interface LocacionPaseadorRepository extends JpaRepository<LocacionPaseador, Integer> {
    boolean existsByUser(User user);
}
