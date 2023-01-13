package com.guvenpanjur.guvenpanjur.service;

import com.guvenpanjur.guvenpanjur.model.dto.request.RequestCreateOffer;
import com.guvenpanjur.guvenpanjur.model.dto.request.RequestUpdateCustomer;
import com.guvenpanjur.guvenpanjur.model.dto.request.RequestUpdateOffer;
import com.guvenpanjur.guvenpanjur.model.dto.response.OfferResponse;
import com.guvenpanjur.guvenpanjur.model.entity.Offer;

import java.util.List;
import java.util.Optional;

public interface OfferService {
    List<OfferResponse> findOffers();
    void saveOffer(RequestCreateOffer request);



}
