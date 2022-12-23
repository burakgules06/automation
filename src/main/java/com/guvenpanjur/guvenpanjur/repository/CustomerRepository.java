package com.guvenpanjur.guvenpanjur.repository;

import com.guvenpanjur.guvenpanjur.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
