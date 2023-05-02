package com.gradusinterview.stockmarket.controller;


import com.gradusinterview.stockmarket.model.Stock;
import com.gradusinterview.stockmarket.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stockSearch")
public class SearchStockController {

    @Autowired
    private StockService stockService;

    @PostMapping
    public List<Stock> searchStocks(@RequestBody Stock stockSearchBody) {
        return stockService.searchStocks(stockSearchBody);
    }

}
