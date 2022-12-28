package com.guvenpanjur.guvenpanjur.model.entity;

import com.guvenpanjur.guvenpanjur.model.entity.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "_offer")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long offerId;
    private double width;
    private double height;
    private int unit;
    private String motordirection;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customers;

}
