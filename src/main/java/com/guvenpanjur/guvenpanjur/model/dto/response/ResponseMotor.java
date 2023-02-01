package com.guvenpanjur.guvenpanjur.model.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class ResponseMotor {
    private Long id;
    private String name;
    private List<ResponseMotorType> motorTypes;
}
