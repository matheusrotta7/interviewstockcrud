package com.gradusinterview.stockmarket.controller;


import com.gradusinterview.stockmarket.model.Stock;
import com.gradusinterview.stockmarket.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockmarketController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @PostMapping
    public Stock addNewStock(@RequestBody Stock stockBody) {
        return stockService.addNewStock(stockBody);
    }

}
