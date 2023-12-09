package com.example.demo.domain.repository.UsuariosRepos;

import com.example.demo.domain.entity.usuariosEntitys.TiposUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TiposUsuario, Integer> {

}
