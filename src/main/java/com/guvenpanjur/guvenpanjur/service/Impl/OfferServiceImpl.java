package com.guvenpanjur.guvenpanjur.service.Impl;

import com.guvenpanjur.guvenpanjur.model.dto.response.OfferResponse;
import com.guvenpanjur.guvenpanjur.model.entity.Offer;
import com.guvenpanjur.guvenpanjur.repository.OfferRepository;
import com.guvenpanjur.guvenpanjur.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;

    @Override
    public List<OfferResponse> findOffers() {
        return offerRepository.findAll().stream()
                .map(offer -> OfferResponse.getInstance(offer))
                .collect(Collectors.toList());
    }

    @Override
    public Offer saveOffer(Offer offer) {
        return offerRepository.save(offer);
    }
}
