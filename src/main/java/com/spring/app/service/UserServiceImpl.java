package com.spring.app.service;


import com.spring.app.exceptions.BadRequestException;
import com.spring.app.exceptions.ResourceNotFoundException;
import com.spring.app.model.User;
import com.spring.app.repository.IRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private IRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByID(Long id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("User not found with id: "+id);
        }

        return userRepository.findById(id).get();
    }

    @Override
    public User createUser(User user) {
        Object age = user.getAge();

        if (user.getName().isEmpty() || user.getName() == null) {
            throw new BadRequestException("name is required");
        }

        if (user.getLastName().isEmpty() || user.getLastName() == null) {
            throw new BadRequestException("lastName is required");
        }

        if (user.getAge() <= 0 || !(age instanceof Integer)) {
            throw new BadRequestException("Age must be a valid number");
        }

        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        User userUpdate = userRepository.findById(id).get();

        if (user.getName().isEmpty() || user.getName() == null) {
            throw new BadRequestException("name is required");
        }

        if (user.getLastName().isEmpty() || user.getLastName() == null) {
            throw new BadRequestException("lastName is required");
        }

        if (user.getAge() <= 0) {
            throw new BadRequestException("Age must be a valid number");
        }

        userUpdate.setName(user.getName());
        userUpdate.setLastName(user.getLastName());
        userUpdate.setAge(user.getAge());
        userRepository.save(userUpdate);
        return userUpdate;
    }

    @Override
    public void deleteUser(Long id) {

        if (userRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("User not found with id: "+id);
        }
        userRepository.delete(userRepository.findById(id).get());
    }
}
