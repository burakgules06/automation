package com.guvenpanjur.guvenpanjur.repository;

import com.guvenpanjur.guvenpanjur.model.entity.Fabric;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FabricRepository extends JpaRepository<Fabric,Long> {
    Optional<Fabric> findByName(String name);
}
