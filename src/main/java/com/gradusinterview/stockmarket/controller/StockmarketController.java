package com.gradusinterview.stockmarket.controller;


import com.gradusinterview.stockmarket.model.Stock;
import com.gradusinterview.stockmarket.service.StockService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/stock")
public class StockmarketController {

    private static Logger logger = Logger.getLogger(StockmarketController.class.getName());

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

    @DeleteMapping("/{id}")
    public void deleteExistingStock(@PathVariable("id") Long id) {
        stockService.deleteExistingStock(id);
    }

    @PutMapping
    public ResponseEntity<Stock> updateExistingStock(@RequestBody Stock stockBody) {
        try {
            return ResponseEntity.ok(stockService.updateExistingStock(stockBody));
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

}
