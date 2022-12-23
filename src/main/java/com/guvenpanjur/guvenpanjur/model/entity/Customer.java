package com.guvenpanjur.guvenpanjur.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;
    //personal
    private String customerName;
    private String customerLastName;
    private String customerTelNo;

    //address
    private String customerCity;
    private String customerDistrict;
    private String customerNeighbourhood;
    private String customerStreet;
    private String customerBuildingNo;
    private String customerNo;

}
