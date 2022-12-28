package com.guvenpanjur.guvenpanjur.model.viewmodel;

import lombok.Data;

@Data
public class CreateCustomerViewModel {
    private Long customerId;
    private String customerName;
    private String customerLastName;
    private String customerTelNo;
    private String customerCity;
    private String customerDistrict;
    private String customerNeighbourhood;
    private String customerStreet;
    private String customerBuildingNo;
    private String customerNo;
}
