package com.gradusinterview.stockmarket.dao;

import com.gradusinterview.stockmarket.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>, CustomStockRepository {

}
