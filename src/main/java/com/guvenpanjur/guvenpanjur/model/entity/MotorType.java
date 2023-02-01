package com.guvenpanjur.guvenpanjur.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@Entity
public class MotorType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private BigDecimal unitCost;
    @ManyToOne()
    private Motor motor;
}
