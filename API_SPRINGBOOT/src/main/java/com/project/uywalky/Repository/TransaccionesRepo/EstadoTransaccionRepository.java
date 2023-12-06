package com.project.uywalky.Repository.TransaccionesRepo;

import com.project.uywalky.Entity.TransaccionesEntitys.EstadoTransaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EstadoTransaccionRepository extends JpaRepository<EstadoTransaccion, Integer> {
}
