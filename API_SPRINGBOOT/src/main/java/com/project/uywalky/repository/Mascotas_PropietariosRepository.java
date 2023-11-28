package com.project.uywalky.repository;

import com.project.uywalky.Entity.MascotasPropietarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Mascotas_PropietariosRepository extends JpaRepository<MascotasPropietarios, Integer> {
}
