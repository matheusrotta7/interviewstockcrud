package com.gradusinterview.stockmarket.service;

import com.gradusinterview.stockmarket.dao.StockRepository;
import com.gradusinterview.stockmarket.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StockService {

    @Autowired
    StockRepository stockRepository;

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
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

//        return stockRepository.searchWithCriteria(stockSearchBody);
        return null;
    }
}
