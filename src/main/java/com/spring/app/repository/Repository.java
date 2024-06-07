package com.spring.app.repository;

import com.spring.app.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Persona, Long> {
}
