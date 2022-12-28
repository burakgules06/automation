package com.guvenpanjur.guvenpanjur.model.dto.request;

import lombok.Data;

public class RequestCreateOffer {
    private double width;
    private double height;
    private int unit;
    private String motordirection;
    private Long customerId;
    

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