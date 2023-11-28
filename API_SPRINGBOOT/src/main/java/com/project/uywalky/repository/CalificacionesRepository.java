package com.project.uywalky.repository;

import com.project.uywalky.Entity.Calificaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CalificacionesRepository extends JpaRepository<Calificaciones, Integer> {
}
