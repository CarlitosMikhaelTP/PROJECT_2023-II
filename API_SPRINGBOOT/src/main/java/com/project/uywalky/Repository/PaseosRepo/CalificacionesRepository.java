package com.project.uywalky.Repository.PaseosRepo;

import com.project.uywalky.Entity.PaseosEntitys.Calificaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CalificacionesRepository extends JpaRepository<Calificaciones, Integer> {
}
