package com.guvenpanjur.guvenpanjur.service;

import com.guvenpanjur.guvenpanjur.model.dto.response.ResponseTryCurrency;

public interface CurrencyService {
    ResponseTryCurrency getTryCurrency();
    void updateTryCurrency();
}
