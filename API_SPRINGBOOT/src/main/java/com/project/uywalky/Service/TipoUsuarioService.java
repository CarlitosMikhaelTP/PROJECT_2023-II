package com.project.uywalky.Service;

import com.project.uywalky.Entity.UsuariosEntitys.TipoUsuario;
import com.project.uywalky.Repository.UsuariosRepo.TipoUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//////////////////////// DESPUES ELIMINAR //////////////////////////7
@Service
public class TipoUsuarioService {
    private final TipoUsuarioRepository tipoUsuarioRepository;

    public TipoUsuarioService(TipoUsuarioRepository tipoUsuarioRepository){
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    public List<TipoUsuario> obtenerTodosLosTiposUsuario(){
        return tipoUsuarioRepository.findAll();
    }
}
