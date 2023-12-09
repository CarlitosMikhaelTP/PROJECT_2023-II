package com.example.demo.domain.serviceImpl.UsuariosServicesImpl;

import com.example.demo.application.service.UsuariosServices.UserService;
import com.example.demo.domain.entity.usuariosEntitys.User;
import com.example.demo.domain.repository.UsuariosRepos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
