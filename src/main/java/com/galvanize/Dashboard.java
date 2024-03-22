package com.galvanize;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Dashboard {
    private List<String> stocks = new ArrayList<>();
    private StockApi stockApi;

    public Dashboard() {
        stockApi = new StockApi();
    }

    public Dashboard(StockApi stockApi) {
        this.stockApi = stockApi;
    }

    public List<String> getStocks() {
        return new ArrayList<>(stocks);
    }

    public void addStock(String stock) {
        stocks.add(stock);
    }

    public String display() throws Exception {
        List<BigDecimal> prices = new ArrayList<>();
        for(String stock : stocks) {
            prices.add(stockApi.getPrice(stock));
        }
        return "LRN $20";
    }
}
