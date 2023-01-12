package com.guvenpanjur.guvenpanjur.controller;

import com.guvenpanjur.guvenpanjur.controller.util.StockDataUtil;
import com.guvenpanjur.guvenpanjur.model.dto.request.RequestCreateStock;
import com.guvenpanjur.guvenpanjur.model.entity.Stock;
import com.guvenpanjur.guvenpanjur.model.viewmodel.CreateStockViewModel;
import com.guvenpanjur.guvenpanjur.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;

    @GetMapping("/stocks")
    public String listStocks(Model model){
        model.addAttribute("stocks", stockService.findStocks());
        return "stocks";
    }
    @GetMapping("stocks/new")
    public String createStock(Model model){
        CreateStockViewModel stockViewModel = new CreateStockViewModel();
        model.addAttribute("stockViewModel", stockViewModel);
        model.addAttribute("productType", StockDataUtil.productType);
        return "create_stock";
    }
    @PostMapping("/stocks")
    public String saveStock(@ModelAttribute("stockViewModel") CreateStockViewModel stock){
        RequestCreateStock createStock = new RequestCreateStock();
        createStock.setPiece(stock.getPiece());
        createStock.setPurchasePrice(stock.getPurchasePrice());
        createStock.setProductType(stock.getProductType());
        createStock.setColor(stock.getColor());
        createStock.setProductName(stock.getProductName());
        createStock.setProductDetails(stock.getProductDetails());
        stockService.saveStock(createStock);
        return "redirect:/stocks";
    }

}
