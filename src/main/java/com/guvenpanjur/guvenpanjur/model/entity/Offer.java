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
    @ElementCollection
    private List<Integer> unit;
    private double kumasEnKesimOlcusu;
    private double kumasBoyKesimOlcusu;
    private double kumasBirimFiyat;
    private double kumasSonFiyat;
    private String motordirection;
    private String offerstatus;
    private String engineControl;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customers;
    private String productTypeOffer;


}
