package com.project.uywalky.Repository.PaseosRepo;

import com.project.uywalky.Entity.PaseosEntitys.Ubicaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UbicacionesRepository extends JpaRepository<Ubicaciones, Integer> {
}
