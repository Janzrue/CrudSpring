package com.spring.app.service;

import com.spring.app.models.User;
import com.spring.app.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service

public class Service {
    @Autowired
    private Repository repositorio;


    public String index() {
        return "CONECTADO";
    }

    public List<User> getAllUsers() {
        return repositorio.findAll();
    }

    public Optional<User> getUserByID(Long id) {
        return repositorio.findById(id);
    }

    public String createUser(@RequestBody User user) {
        repositorio.save(user);
        return "Usuario creado";
    }

    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatePersona = repositorio.findById(id).get();
        updatePersona.setName(user.getName());
        updatePersona.setPhone(user.getPhone());
        repositorio.save(updatePersona);
        return "Usuario editado";
    }

    public String deleteUser(@PathVariable Long id) {
        User deleteUser = repositorio.findById(id).get();
        repositorio.delete(deleteUser);
        return "Usuario eliminado";
    }

}
