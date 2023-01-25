package com.guvenpanjur.guvenpanjur.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable

public class components {
    private int unit;
    private double width;
    private double height;
}
