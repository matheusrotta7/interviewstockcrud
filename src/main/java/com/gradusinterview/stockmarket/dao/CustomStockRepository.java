package com.gradusinterview.stockmarket.dao;

import com.gradusinterview.stockmarket.model.Stock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomStockRepository {

    public List<Stock> searchStocksWithCriteria(Stock searchStockBody);

    public List<Stock> findAllOrderById();

}
