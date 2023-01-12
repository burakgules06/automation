package com.guvenpanjur.guvenpanjur.repository;

import com.guvenpanjur.guvenpanjur.model.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Long> {
}
