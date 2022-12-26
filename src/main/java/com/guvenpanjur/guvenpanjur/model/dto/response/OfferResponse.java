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
    private double width;
    private double height;
    private String unit;
    private String motordirection;
    private Long customersId;

    public static OfferResponse getInstance(Offer offer){
        OfferResponse offerResponse = new OfferResponse();
        offerResponse.setId(offer.getOfferId());
        offerResponse.setWidth(offer.getWidth());
        offerResponse.setHeight(offer.getHeight());
        offerResponse.setUnit(offer.getUnit());
        offerResponse.setMotordirection(offer.getMotordirection());
        if(offer.getCustomers()!=null)
            offerResponse.setCustomersId(offer.getOfferId());
        return offerResponse;
    }
}
