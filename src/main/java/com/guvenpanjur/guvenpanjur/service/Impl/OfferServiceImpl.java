package com.guvenpanjur.guvenpanjur.service.Impl;

import com.guvenpanjur.guvenpanjur.controller.util.OfferDataUtil;
import com.guvenpanjur.guvenpanjur.model.dto.request.RequestCreateOffer;
import com.guvenpanjur.guvenpanjur.model.dto.response.OfferResponse;
import com.guvenpanjur.guvenpanjur.model.dto.response.ResponseCustomer;
import com.guvenpanjur.guvenpanjur.model.entity.Customer;
import com.guvenpanjur.guvenpanjur.model.entity.Offer;
import com.guvenpanjur.guvenpanjur.repository.OfferRepository;
import com.guvenpanjur.guvenpanjur.service.CustomerService;
import com.guvenpanjur.guvenpanjur.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final CustomerService customerService;

    @Override
    public List<OfferResponse> findOffers() {
        return offerRepository.findAll().stream()
                .map(offer -> {
                    var res=modelMapper.map(offer,OfferResponse.class);
                    var resCustomer=modelMapper.map(offer.getCustomers(),ResponseCustomer.class);
                    res.setCustomer(resCustomer);
                    return res;

                })
                .collect(Collectors.toList());
    }
    @Override
    public void saveOffer(RequestCreateOffer request) {
        Optional<Customer> customer = customerService.getById(request.getCustomerId());
        if(customer != null) {
            Offer offer=new Offer();
            offer.setHeight(request.getHeight());
            offer.setWidth(request.getWidth());
            offer.setUnit(request.getUnit());
            offer.setCustomers(customer.get());
            offer.setMotordirection(request.getMotordirection());
            offer.setOfferstatus(request.getOfferstatus());
            offer.setKumasBoyKesimOlcusu(request.getKumasBoyKesimOlcusu());
            offer.setKumasEnKesimOlcusu(request.getKumasEnKesimOlcusu());
            offer.setKumasSonFiyat(request.getKumasSonFiyat());
            offerRepository.save(offer);
        } else {
            throw new RuntimeException("Id Null!");
        }
    }
}
