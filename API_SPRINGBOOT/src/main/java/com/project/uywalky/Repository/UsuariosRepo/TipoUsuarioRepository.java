package com.project.uywalky.Repository.UsuariosRepo;

import com.project.uywalky.Entity.UsuariosEntitys.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {

}
