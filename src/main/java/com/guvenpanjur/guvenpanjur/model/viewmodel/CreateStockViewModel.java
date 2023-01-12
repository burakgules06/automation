package com.guvenpanjur.guvenpanjur.model.viewmodel;

import lombok.Data;

@Data
public class CreateStockViewModel {
    private int piece;
    private double purchasePrice;
    private String productType;
    private String color;
    private String productName;
    private String productDetails;

}
