package com.guvenpanjur.guvenpanjur.service.Impl;

import com.guvenpanjur.guvenpanjur.model.entity.Offer;
import com.guvenpanjur.guvenpanjur.repository.CustomerRepository;
import com.guvenpanjur.guvenpanjur.repository.OfferRepository;
import com.guvenpanjur.guvenpanjur.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final CustomerRepository customerRepository;

    @Override
    public List<Offer> findOffers() {
        return offerRepository.findAll();
    }

    @Override
    public Offer saveOffer(Offer offer) {
        return offerRepository.save(offer);
    }
}
