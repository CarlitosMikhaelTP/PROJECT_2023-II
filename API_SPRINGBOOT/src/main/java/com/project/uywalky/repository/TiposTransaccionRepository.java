package com.project.uywalky.repository;

import com.project.uywalky.Entity.TiposTransaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiposTransaccionRepository extends JpaRepository<TiposTransaccion, Integer> {
}
