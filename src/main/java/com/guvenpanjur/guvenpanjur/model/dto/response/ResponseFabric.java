package com.guvenpanjur.guvenpanjur.model.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class ResponseFabric {
    private Long id;
    private List<ResponseFabricType> fabricTypes;
}
