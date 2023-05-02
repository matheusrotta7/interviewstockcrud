package com.gradusinterview.stockmarket.dao;

import com.gradusinterview.stockmarket.model.Stock;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomStockRepositoryImpl implements CustomStockRepository {

    @PersistenceContext
    EntityManager em;
    @Override
    public List<Stock> searchStocksWithCriteria(Stock searchStockBody) {
        String queryString = "SELECT * FROM stocks WHERE 1=1";
        if (searchStockBody.getName() != null) {
            queryString += " AND name LIKE " + searchStockBody.getName();
        }
        if (searchStockBody.getSector() != null) {
            queryString += " AND sector LIKE " + searchStockBody.getSector();
        }
        if (searchStockBody.getTicket() != null) {
            queryString += " AND ticket LIKE " + searchStockBody.getTicket();
        }

        Query nativeQuery = em.createNativeQuery(queryString);
        List<Stock> resultList = nativeQuery.getResultList();
        return resultList;
    }
}
