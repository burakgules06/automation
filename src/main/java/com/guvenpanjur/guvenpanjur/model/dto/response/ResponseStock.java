package com.guvenpanjur.guvenpanjur.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStock {
    private long id;
    private int piece;
    private double purchasePrice;
    private String productType;
    private String color;
}
