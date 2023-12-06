package com.project.uywalky.Repository.PaseosRepo;

import com.project.uywalky.Entity.PaseosEntitys.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservasRepository extends JpaRepository<Reservas, Integer> {

}
