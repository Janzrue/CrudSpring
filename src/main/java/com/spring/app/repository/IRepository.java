package com.spring.app.repository;

import com.spring.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepository extends JpaRepository<User, Long> {
}
