package com.guvenpanjur.guvenpanjur.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="_stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int piece;
    private String brand;
    private String model;
    private String productName;
    private String details;
    private String category;
    private String color;
    private double purchasePrice;
    private double measurement;
    private double componentHeight;
}
