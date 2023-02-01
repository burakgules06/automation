package com.guvenpanjur.guvenpanjur.repository;

import com.guvenpanjur.guvenpanjur.model.entity.Motor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MotorRepository extends JpaRepository<Motor,Long> {
    Optional<Motor> findByName(String name);
}
