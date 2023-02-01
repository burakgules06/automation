package com.guvenpanjur.guvenpanjur.model.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ResponseMotorType {
    private Long id;
    private String model;
    private BigDecimal unitCost;
}
