package com.project.uywalky.Repository.MascotasRepo;

import com.project.uywalky.Entity.MascotasEntitys.MascotasPropietarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Mascotas_PropietariosRepository extends JpaRepository<MascotasPropietarios, Integer> {
}
