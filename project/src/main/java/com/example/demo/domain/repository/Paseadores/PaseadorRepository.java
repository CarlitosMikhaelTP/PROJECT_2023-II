package com.example.demo.domain.repository.Paseadores;

import com.example.demo.domain.entity.paseadores.Paseadores;
import com.example.demo.domain.entity.usuarios.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaseadorRepository extends JpaRepository<Paseadores, Integer> {

    boolean existsByUser(User user);
}
