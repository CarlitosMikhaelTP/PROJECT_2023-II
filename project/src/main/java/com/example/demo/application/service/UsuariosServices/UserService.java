package com.example.demo.application.service.UsuariosServices;

import com.example.demo.domain.entity.usuariosEntitys.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    // Método para encontrar todos los regitros de la base
    // de datos de la entidad Usuarios
    List<User> findAll();

}
