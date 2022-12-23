package com.guvenpanjur.guvenpanjur.model.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private String customerName;
    private String customerLastName;
    private String customerTelNo;
    private long addressId;

}
