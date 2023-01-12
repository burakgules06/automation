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
    private double purchasePrice;
    private String productType;
    private String color;
    private String productName;
    private String stockDetails;
}
