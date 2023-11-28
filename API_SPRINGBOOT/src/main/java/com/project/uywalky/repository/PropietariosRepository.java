package com.project.uywalky.repository;

import com.project.uywalky.Entity.Propietarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropietariosRepository extends JpaRepository<Propietarios, Integer> {
}
