package com.guvenpanjur.guvenpanjur.service;

import com.guvenpanjur.guvenpanjur.model.entity.Offer;

import java.util.List;

public interface OfferService {
    List<Offer> findOffers();

    Offer saveOffer(Offer offer);
}
