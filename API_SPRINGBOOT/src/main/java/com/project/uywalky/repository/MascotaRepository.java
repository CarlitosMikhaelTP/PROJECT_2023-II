package com.project.uywalky.repository;

import com.project.uywalky.Entity.Mascotas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepository extends JpaRepository<Mascotas, Integer> {
}
