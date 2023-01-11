package com.guvenpanjur.guvenpanjur.scheduled;

import com.guvenpanjur.guvenpanjur.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
@RequiredArgsConstructor
public class CurrencySch {
    private final CurrencyService currencyService;
    @Scheduled(fixedDelay =18000000)
    public void tryCurrency(){
        currencyService.updateTryCurrency();
    }
}
