package com.project.uywalky.Repository.PaseosRepo;

import com.project.uywalky.Entity.PaseosEntitys.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentariosRepository extends JpaRepository<Comentarios, Integer> {
}
