package com.project.uywalky.Repository.PropietariosRepo;

import com.project.uywalky.Entity.PropietariosEntitys.LocacionPropietario;
import com.project.uywalky.Entity.PropietariosEntitys.Propietarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocacionPropietarioRepository extends JpaRepository<LocacionPropietario, Integer> {
    boolean existsByPropietarios(Propietarios propietarios);
}
