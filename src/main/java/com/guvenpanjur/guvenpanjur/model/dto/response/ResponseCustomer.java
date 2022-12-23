package com.guvenpanjur.guvenpanjur.model.dto.response;

import lombok.Data;

@Data
public class ResponseCustomer {
    private long customerId;
    private String customerName;
    private String customerLastName;
    private String customerTelNo;
}
