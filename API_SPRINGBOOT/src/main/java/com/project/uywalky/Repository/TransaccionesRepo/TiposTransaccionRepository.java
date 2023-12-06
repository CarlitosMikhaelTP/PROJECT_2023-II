package com.project.uywalky.Repository.TransaccionesRepo;

import com.project.uywalky.Entity.TransaccionesEntitys.TiposTransaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiposTransaccionRepository extends JpaRepository<TiposTransaccion, Integer> {
}
