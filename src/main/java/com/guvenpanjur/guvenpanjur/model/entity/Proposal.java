package com.guvenpanjur.guvenpanjur.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Proposal {
    @Id
    private Long id;
    private String color;
    private boolean colorType;
    private boolean packageType;
    private boolean printType;
    private boolean montageType;
    @OneToMany
    private List<Poz> poz;
    @ManyToOne
    private FabricType fabricType;
    @ManyToOne
    private MotorType motorType;
    @ElementCollection
    private List<String> controller;

}
