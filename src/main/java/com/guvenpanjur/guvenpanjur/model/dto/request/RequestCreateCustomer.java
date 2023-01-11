package com.guvenpanjur.guvenpanjur.model.dto.request;

import lombok.Data;


public class RequestCreateCustomer {
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
    public String getCustomerName() {
        return customerName;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerTelNo() {
        return customerTelNo;
    }

    public void setCustomerTelNo(String customerTelNo) {
        this.customerTelNo = customerTelNo;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerDistrict() {
        return customerDistrict;
    }

    public void setCustomerDistrict(String customerDistrict) {
        this.customerDistrict = customerDistrict;
    }

    public String getCustomerNeighbourhood() {
        return customerNeighbourhood;
    }

    public void setCustomerNeighbourhood(String customerNeighbourhood) {
        this.customerNeighbourhood = customerNeighbourhood;
    }

    public String getCustomerStreet() {
        return customerStreet;
    }

    public void setCustomerStreet(String customerStreet) {
        this.customerStreet = customerStreet;
    }

    public String getCustomerBuildingNo() {
        return customerBuildingNo;
    }

    public void setCustomerBuildingNo(String customerBuildingNo) {
        this.customerBuildingNo = customerBuildingNo;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }
}
