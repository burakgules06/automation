package com.guvenpanjur.guvenpanjur.service;

import com.guvenpanjur.guvenpanjur.model.dto.request.RequestCreateStock;
import com.guvenpanjur.guvenpanjur.model.entity.Stock;

import java.util.List;

public interface StockService {
    List<Stock> findStocks();
    Stock saveStock(RequestCreateStock request);

}
