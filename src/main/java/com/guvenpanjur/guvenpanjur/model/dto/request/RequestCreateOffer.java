package com.guvenpanjur.guvenpanjur.model.dto.request;

import lombok.Data;
@Data

public class RequestCreateOffer {
    private double width;
    private double height;
    private int unit;
    private String motordirection;
    private String offerstatus;
    private String productTypeOffer;
    private double kumasEnKesimOlcusu;

    private double kumasBoyKesimOlcusu;

    private double kumasBirimFiyat = 2.0;
    private double kumasSonFiyat;
    private Long customerId;

}