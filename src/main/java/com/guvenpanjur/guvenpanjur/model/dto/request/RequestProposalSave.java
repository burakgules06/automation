package com.guvenpanjur.guvenpanjur.model.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class RequestProposalSave {
    private Long motorTypeId;
    private Long fabricTypeId;
    private String color;
    private int piece;
    private boolean colorType;
    private boolean packageType;
    private boolean printType;
    private boolean montageType;
    private List<String> controller;
    private List<RequestPozSave> pozs;
}
