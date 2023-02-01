package com.guvenpanjur.guvenpanjur.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@Entity
public class FabricType {
    @Id
    private Long id;
    private String model;
    private BigDecimal unitCost;
    @ManyToOne
    private  Fabric fabric;
}
