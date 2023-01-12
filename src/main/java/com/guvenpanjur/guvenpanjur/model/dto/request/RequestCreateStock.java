package com.guvenpanjur.guvenpanjur.model.dto.request;

import lombok.Data;

@Data
public class RequestCreateStock {
    private long id;
    private int piece;
    private double purchasePrice;
    private String productType;
    private String color;
    private String productName;
    private String productDetails;
}
