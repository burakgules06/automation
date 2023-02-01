package com.guvenpanjur.guvenpanjur.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class Fabric {
    @Id
    private Long id;
    private String name;
    @OneToMany(mappedBy = "fabric",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<FabricType> fabricTypes;
}
