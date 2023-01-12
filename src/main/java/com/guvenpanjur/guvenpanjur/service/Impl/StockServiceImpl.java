package com.guvenpanjur.guvenpanjur.service.Impl;

import com.guvenpanjur.guvenpanjur.model.dto.request.RequestCreateStock;
import com.guvenpanjur.guvenpanjur.model.dto.response.ResponseStock;
import com.guvenpanjur.guvenpanjur.model.entity.Stock;
import com.guvenpanjur.guvenpanjur.repository.StockRepository;
import com.guvenpanjur.guvenpanjur.service.StockService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService{
    private final StockRepository stockRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<Stock> findStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock saveStock(RequestCreateStock request) {
        Stock stock = new Stock();
        stock.setPiece(request.getPiece());
        stock.setPurchasePrice(request.getPurchasePrice());
        stock.setProductType(request.getProductType());
        stock.setColor(request.getColor());
        stock.setProductName(request.getProductName());
        stock.setStockDetails(request.getProductDetails());
        var stockSave = stockRepository.save(stock);
        return stockSave;
    }
}
