package com.gradusinterview.stockmarket;

import com.gradusinterview.stockmarket.dao.CustomStockRepositoryImpl;
import com.gradusinterview.stockmarket.model.Stock;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.util.Assert;

public class CustomStockRepositoryImplTest {

    @Test
    public void WhenCallingSearchWithCriteriaWithSpecifiedName_ExpectQueryToContainSuchRestriction(){

        EntityManager entityManagerMock = Mockito.mock(EntityManager.class);
        Query queryMock = Mockito.mock(Query.class);
        Mockito.when(entityManagerMock.createQuery(Mockito.anyString())).thenReturn(queryMock);

        CustomStockRepositoryImpl stockRepositoryImpl = new CustomStockRepositoryImpl(entityManagerMock);
        stockRepositoryImpl.searchStocksWithCriteria(new Stock(null, "Magalu", null, 0, null));

        ArgumentCaptor<String> queryStringCaptor = ArgumentCaptor.forClass(String.class);
        Mockito.verify(entityManagerMock).createQuery(queryStringCaptor.capture());
        String queryString = queryStringCaptor.getValue();
        Assert.hasText("and s.name like 'Magalu'", queryString);
    }
}
