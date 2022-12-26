package com.guvenpanjur.guvenpanjur.model.dto.request;

import com.guvenpanjur.guvenpanjur.model.entity.Customer;
import com.guvenpanjur.guvenpanjur.model.entity.Offer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOfferRequest {
    private double width;
    private double height;
    private String unit;
    private String motordirection;
    private List<Customer> customersId;
    public Offer convertOffer(){
        Offer offer = new Offer();
        offer.setWidth(this.width);
        offer.setHeight(this.height);
        offer.setMotordirection(this.motordirection);
        offer.setUnit(this.unit);

        return offer;
    }
}
