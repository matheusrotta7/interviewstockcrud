package com.gradusinterview.stockmarket.dao;

import com.gradusinterview.stockmarket.model.Stock;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CustomStockRepositoryImpl implements CustomStockRepository {

    @PersistenceContext
    EntityManager em;
    @Override
    public List<Stock> searchStocksWithCriteria(Stock searchStockBody) {
        String queryString = "Select s from Stock s where 1=1"; //jpql
        if (searchStockBody.getName() != null) {
            queryString += " and s.name like '" + searchStockBody.getName() + "'";
        }
        if (searchStockBody.getSector() != null) {
            queryString += " and s.sector like '" + searchStockBody.getSector() + "'";
        }
        if (searchStockBody.getTicket() != null) {
            queryString += " and s.ticket like '" + searchStockBody.getTicket() + "'";
        }

        Query query = em.createQuery(queryString);
        List<Stock> resultList = (List<Stock>) query.getResultList();

        return resultList;
    }
}
