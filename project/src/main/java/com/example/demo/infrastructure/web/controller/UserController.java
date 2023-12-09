package com.example.demo.infrastructure.web.controller;

import com.example.demo.application.service.UsuariosServices.UserService;
import com.example.demo.domain.entity.usuariosEntitys.User;
import com.example.demo.infrastructure.security.configuration.authentication.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    AuthenticationService service;

    // ENDPOINT PARA MOSTRAR LA LISTA DE USUARIOS
    @GetMapping("/list")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = service.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
