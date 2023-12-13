package com.example.demo.domain.repository.Transacciones;

import com.example.demo.domain.entity.transacciones.EstadosTransaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoTransaccionRepository extends JpaRepository<EstadosTransaccion, Integer> {
}
