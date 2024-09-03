package com.spring.app.service;


import com.spring.app.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

    List<User> getAllUsers();

    User getUserByID(Long id);

    User createUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);

}
