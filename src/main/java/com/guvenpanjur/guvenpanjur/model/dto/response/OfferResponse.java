package com.guvenpanjur.guvenpanjur.model.dto.response;

import com.guvenpanjur.guvenpanjur.model.entity.Offer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferResponse {
    private Long id;
    private long offerId;
    private double width;
    private double height;
    private int unit;
    private String motordirection;
    private Long customersId;
    private ResponseCustomer customer;

}
