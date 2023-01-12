package com.guvenpanjur.guvenpanjur.service.Impl;

import com.guvenpanjur.guvenpanjur.model.dto.response.ResponseTryCurrency;
import com.guvenpanjur.guvenpanjur.repository.jsonRepo.TryCurrencyRepository;
import com.guvenpanjur.guvenpanjur.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {
    private final TryCurrencyRepository tryCurrencyRepository;
    @Override
    public ResponseTryCurrency getTryCurrency() {
        try {
            var truCurrency=tryCurrencyRepository.getTryCurrency();
            //map to response
            return null;//response
        }catch (Exception e){

        }
        return null;
    }

    @Override
    public void updateTryCurrency() {

    }
}
