package com.guvenpanjur.guvenpanjur.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Motor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "motor",cascade = CascadeType.ALL)
    private List<MotorType> motorTypes;
}
