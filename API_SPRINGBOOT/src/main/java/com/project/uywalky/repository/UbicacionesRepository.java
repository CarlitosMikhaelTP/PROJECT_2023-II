package com.project.uywalky.repository;

import com.project.uywalky.Entity.Ubicaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UbicacionesRepository extends JpaRepository<Ubicaciones, Integer> {
}
