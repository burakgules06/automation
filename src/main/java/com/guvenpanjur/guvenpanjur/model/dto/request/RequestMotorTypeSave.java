package com.guvenpanjur.guvenpanjur.model.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RequestMotorTypeSave {
    private String model;
    private BigDecimal unitCost;
}
