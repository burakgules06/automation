package com.guvenpanjur.guvenpanjur.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    //personal
    @Column(length = 45, nullable = false)
    private String customerName;
    @Column(length = 45, nullable = false)
    private String customerLastName;
    @Column(length = 12, nullable = false)
    private String customerTelNo;

    //address
    private String customerCity;
    private String customerDistrict;
    private String customerNeighbourhood;
    private String customerStreet;
    private String customerBuildingNo;
    private String customerNo;


}
