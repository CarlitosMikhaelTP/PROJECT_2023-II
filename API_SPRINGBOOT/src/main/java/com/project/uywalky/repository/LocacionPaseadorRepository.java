package com.project.uywalky.repository;

import com.project.uywalky.Entity.LocacionPaseador;
import com.project.uywalky.Entity.Paseadores;
import com.project.uywalky.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public interface LocacionPaseadorRepository extends JpaRepository<LocacionPaseador, Integer> {
    boolean existsByPaseadores(Paseadores paseadores);
}
