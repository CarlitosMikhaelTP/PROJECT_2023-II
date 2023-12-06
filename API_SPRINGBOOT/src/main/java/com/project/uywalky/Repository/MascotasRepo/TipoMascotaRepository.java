package com.project.uywalky.Repository.MascotasRepo;

import com.project.uywalky.Entity.MascotasEntitys.TipoMascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoMascotaRepository extends JpaRepository<TipoMascota, Integer> {
}
