package com.galvanize;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StockApiTests {
    @Test
    void throwsException() {
        StockApi stockApi = new StockApi();
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            stockApi.getPrice("TEST");
        });
        Assertions.assertTrue(exception.getMessage().contains("Mock"));
    }
}
