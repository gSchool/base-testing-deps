package com.galvanize;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;

public class DashboardTests {
    @Test
    void canBeCreated() {
        Dashboard dashboard = new Dashboard();
        Assertions.assertNotNull(dashboard);
    }

    @Test
    void canGetEmptyStockList() {
        Dashboard dashboard = new Dashboard();
        List<String> results = dashboard.getStocks();
        Assertions.assertEquals(0, results.size());
    }

    @Test
    void canAddAStock() {
        Dashboard dashboard = new Dashboard();
        String stock = "LRN";
        dashboard.addStock(stock);
        List<String> results = dashboard.getStocks();
        Assertions.assertEquals(1, results.size());
        Assertions.assertEquals(stock, results.get(0));
    }

    @Test
    void canDisplayStockPrices() throws Exception {
        String stock = "LRN";
        StockApi mockedApi = Mockito.mock(StockApi.class);
        Mockito.when(mockedApi.getPrice(stock)).thenReturn(BigDecimal.valueOf(20.00));
        Dashboard dashboard = new Dashboard(mockedApi);
        dashboard.addStock(stock);
        String output = dashboard.display();
        MatcherAssert.assertThat(output, CoreMatchers.containsString("LRN"));
        MatcherAssert.assertThat(output, CoreMatchers.containsString("$20"));
    }
}
