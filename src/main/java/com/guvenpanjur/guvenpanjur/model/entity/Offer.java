package com.guvenpanjur.guvenpanjur.model.entity;


import com.guvenpanjur.guvenpanjur.model.enums.motordirection;
import com.guvenpanjur.guvenpanjur.model.enums.orderstatus;
import com.guvenpanjur.guvenpanjur.model.enums.productinfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "_offer")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long offerId;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    @OneToOne
    private Stock stock;
    @Enumerated(EnumType.STRING)
    private motordirection motordirection;
    @Enumerated(EnumType.STRING)
    private productinfo productinfo;
    @Enumerated(EnumType.STRING)
    private orderstatus orderstatus;
    private double width;
    private double height;
}
