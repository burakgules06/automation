package com.guvenpanjur.guvenpanjur.model.viewmodel;

import lombok.Data;

@Data
public class CreateOfferViewModel {
    private double width;
    private double height;
    private int unit;
    private String motordirection;
    private Long customerId;
}
