package com.gradusinterview.stockmarket;

import com.gradusinterview.stockmarket.dao.StockRepository;
import com.gradusinterview.stockmarket.service.StockService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StockServiceTest {


    private StockRepository stockRepositoryMock;

    private StockService stockService;

    @Test
    public void WhenGetAllStocksIsCalled_ExpectRepositoryFindAllToBeCalled() {

        stockRepositoryMock = Mockito.mock(StockRepository.class);

        stockService = new StockService(stockRepositoryMock);
        stockService.getAllStocks();

        Mockito.verify(stockRepositoryMock, Mockito.times(1)).findAllOrderById();
    }
}
