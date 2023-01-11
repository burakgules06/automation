package com.guvenpanjur.guvenpanjur.model.dto.request;

import lombok.Data;

public class RequestCreateOffer {
    private double width;
    private double height;
    private int unit;
    private String motordirection;
    private String offerstatus;

    private double kumasEnKesimOlcusu;

    private double kumasBoyKesimOlcusu;

    private double kumasBirimFiyat = 2.0;
    private double kumasSonFiyat;
    private Long customerId;
    public String getOfferstatus() {
        return offerstatus;
    }

    public void setOfferstatus(String offerstatus) {
        this.offerstatus = offerstatus;
    }
    public double getKumasEnKesimOlcusu() {
        return kumasEnKesimOlcusu;
    }

    public void setKumasEnKesimOlcusu(double kumasEnKesimOlcusu) {
        this.kumasEnKesimOlcusu = kumasEnKesimOlcusu;
    }

    public double getKumasBoyKesimOlcusu() {
        return kumasBoyKesimOlcusu;
    }

    public void setKumasBoyKesimOlcusu(double kumasBoyKesimOlcusu) {
        this.kumasBoyKesimOlcusu = kumasBoyKesimOlcusu;
    }
    public double getKumasBirimFiyat() {
        return kumasBirimFiyat;
    }

    public void setKumasBirimFiyat(double kumasBirimFiyat) {
        this.kumasBirimFiyat = kumasBirimFiyat;
    }

    public double getKumasSonFiyat() {
        return kumasSonFiyat;
    }

    public void setKumasSonFiyat(double kumasSonFiyat) {
        this.kumasSonFiyat = kumasSonFiyat;
    }


    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getMotordirection() {
        return motordirection;
    }

    public void setMotordirection(String motordirection) {
        this.motordirection = motordirection;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}