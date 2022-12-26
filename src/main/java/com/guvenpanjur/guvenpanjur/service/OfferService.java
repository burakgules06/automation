package com.guvenpanjur.guvenpanjur.service;

import com.guvenpanjur.guvenpanjur.model.dto.response.OfferResponse;
import com.guvenpanjur.guvenpanjur.model.entity.Offer;

import java.util.List;

public interface OfferService {
    List<OfferResponse> findOffers();

    Offer saveOffer(Offer offer);
}
