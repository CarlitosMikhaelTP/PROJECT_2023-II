package com.project.uywalky.repository;

import com.project.uywalky.Entity.Paseadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaseadoresRepository extends JpaRepository<Paseadores, Integer> {
}
