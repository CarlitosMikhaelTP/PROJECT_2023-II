package com.project.uywalky.Repository.TransaccionesRepo;

import com.project.uywalky.Entity.TransaccionesEntitys.Transacciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionesRepository extends JpaRepository<Transacciones, Integer> {
}
