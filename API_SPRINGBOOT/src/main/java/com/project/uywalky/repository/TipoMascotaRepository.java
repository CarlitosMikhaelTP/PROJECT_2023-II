package com.project.uywalky.repository;

import com.project.uywalky.Entity.TipoMascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface TipoMascotaRepository extends JpaRepository<TipoMascota, Integer> {
}
