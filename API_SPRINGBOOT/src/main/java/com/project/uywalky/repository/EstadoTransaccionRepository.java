package com.project.uywalky.repository;

import com.project.uywalky.Entity.EstadoTransaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EstadoTransaccionRepository extends JpaRepository<EstadoTransaccion, Integer> {
}
