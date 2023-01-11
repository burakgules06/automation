package com.guvenpanjur.guvenpanjur.model.entity;

import com.guvenpanjur.guvenpanjur.model.enums.orderstatus;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name="_orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;
    @OneToOne
    private Offer offer;
}
