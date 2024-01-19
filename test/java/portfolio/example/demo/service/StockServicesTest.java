package portfolio.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import portfolio.example.demo.entity.Stock;
import portfolio.example.demo.repository.StockRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StockServicesTest {
    @Autowired
    StockServices stockServices;
    @Autowired
    StockRepository stockRepository;
    @Test
    void  showStockDetailsWithValidStockId(){
        long stockId=500002;
        Optional<Stock> optionalStock=stockServices.getStockDetailById(stockId);
        Stock stock = optionalStock.get();
        assertEquals(stock.getStockId(), stockId);
    }
//    @Test
//    void expectStockDetailsWhenValidStockIdIsGiven() {
//        int stockId = 500032;
//        Optional<Stock> optionalStock = stockService.getStockDetails(stockId);
//        Stock stock = optionalStock.get();
//        assertEquals(stock.getId(), stockId);
//    }
}