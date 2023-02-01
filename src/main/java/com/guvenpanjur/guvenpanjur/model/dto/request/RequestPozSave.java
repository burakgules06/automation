package com.guvenpanjur.guvenpanjur.model.dto.request;

import com.guvenpanjur.guvenpanjur.model.enums.MotorYon;
import lombok.Data;


@Data
public class RequestPozSave {
    private int unit;
    private double width;
    private double height;
    private MotorYon motorYon;
}
