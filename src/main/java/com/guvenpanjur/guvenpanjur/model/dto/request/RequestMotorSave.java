package com.guvenpanjur.guvenpanjur.model.dto.request;

import com.guvenpanjur.guvenpanjur.model.entity.MotorType;
import lombok.Data;

import java.util.List;

@Data
public class RequestMotorSave {
    private String name;
    private List<RequestMotorTypeSave> motorType;
}
