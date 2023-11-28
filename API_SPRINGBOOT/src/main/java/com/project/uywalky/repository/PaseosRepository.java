package com.project.uywalky.repository;

import com.project.uywalky.Entity.Paseos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaseosRepository extends JpaRepository<Paseos, Integer> {
}
