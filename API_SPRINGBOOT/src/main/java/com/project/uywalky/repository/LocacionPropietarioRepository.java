package com.project.uywalky.repository;

import com.project.uywalky.Entity.LocacionPropietario;
import com.project.uywalky.Entity.Propietarios;
import com.project.uywalky.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocacionPropietarioRepository extends JpaRepository<LocacionPropietario, Integer> {
    boolean existsByPropietarios(Propietarios propietarios);
}
