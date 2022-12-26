package com.guvenpanjur.guvenpanjur.model.enums;

public enum motordirection {
    LEFT("Sol"),
    RIGHT("Sağ");

    private final String displayValue;

    motordirection(String displayValue){
        this.displayValue = displayValue;
    }
    public String getDisplayValue(){
        return displayValue;
    }
}
