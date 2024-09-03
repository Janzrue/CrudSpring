package com.spring.app.controller;

import com.spring.app.model.User;
import com.spring.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    @Autowired
    private UserService userservice;

    @GetMapping
    ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userservice.getAllUsers());
    }

    @GetMapping("/{id}")
    ResponseEntity<User> getUserByID(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(userservice.getUserByID(id));
    }

    @PostMapping
    ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = this.userservice.createUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId())
                .toUri();

        return ResponseEntity.created(location).body(createdUser);
    }


    @PutMapping("/{id}")
    ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return ResponseEntity.ok().body(this.userservice.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        this.userservice.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
