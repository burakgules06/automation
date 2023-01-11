package com.guvenpanjur.guvenpanjur.model.dto.request;

import lombok.Data;

@Data
public class RequestUpdateCustomer {

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
