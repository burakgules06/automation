package com.guvenpanjur.guvenpanjur.model.entity;

import com.guvenpanjur.guvenpanjur.model.enums.MotorYon;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Data
@Entity
public class Poz {
    @Id
    private Long id;
    private int unit;
    private double width;
    private double height;
    @Enumerated
    private MotorYon motorYon;
}
