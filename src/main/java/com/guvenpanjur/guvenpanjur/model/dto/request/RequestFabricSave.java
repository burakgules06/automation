package com.guvenpanjur.guvenpanjur.model.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class RequestFabricSave {
    private String name;
    private List<RequestFabricTypeSave> fabricType;
}
