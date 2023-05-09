package com.gradusinterview.stockmarket.service;

import com.gradusinterview.stockmarket.dao.StockRepository;
import com.gradusinterview.stockmarket.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StockService {

    private StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getAllStocks() {
        return stockRepository.findAllOrderById();
    }

    public Stock addNewStock(Stock stockBody) {
        return stockRepository.save(stockBody);
    }

    public void deleteExistingStock(Long id) {
        stockRepository.deleteById(id);
    }

    public Stock updateExistingStock(Stock stockBody) {
        return stockRepository.save(stockBody);
    }

    public List<Stock> searchStocks(Stock stockSearchBody) {

        return stockRepository.searchStocksWithCriteria(stockSearchBody);
    }
}
