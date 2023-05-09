package com.gradusinterview.stockmarket.service;

import com.gradusinterview.stockmarket.dao.StockRepository;
import com.gradusinterview.stockmarket.exception.StockException;
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

    public Stock updateExistingStock(Stock stockBody) throws Exception {
        if (stockRepository.existsById(stockBody.getId())) {
            return stockRepository.save(stockBody);
        } else {
            throw new StockException("There was no entity with id " + stockBody.getId() + " in the database to be updated");
        }
    }

    public List<Stock> searchStocks(Stock stockSearchBody) {

        return stockRepository.searchStocksWithCriteria(stockSearchBody);
    }
}
