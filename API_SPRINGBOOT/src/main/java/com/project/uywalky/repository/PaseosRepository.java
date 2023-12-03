package com.project.uywalky.repository;

import com.project.uywalky.Entity.Paseos;
import com.project.uywalky.Entity.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaseosRepository extends JpaRepository<Paseos, Integer> {
    Boolean existsByReservas(Reservas reservas);
}
