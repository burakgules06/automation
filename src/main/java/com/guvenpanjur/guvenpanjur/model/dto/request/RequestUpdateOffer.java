package com.guvenpanjur.guvenpanjur.model.dto.request;

import lombok.Data;

@Data
public class RequestUpdateOffer {
    private long offerId;
    private double width;
    private double height;
    private int unit;

}
