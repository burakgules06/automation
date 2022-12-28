package com.guvenpanjur.guvenpanjur.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCustomer {
    private long customerId;
    private String customerName;
    private String customerLastName;
    private String customerTelNo;
}
