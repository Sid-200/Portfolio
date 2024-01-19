package portfolio.example.demo.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import portfolio.example.demo.entity.Stock;
import portfolio.example.demo.repository.StockRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("first_test")
@SpringBootTest
class StockServicesTest {

    @Autowired
    private StockServices stockServices;

    @Autowired
    private StockRepository stockRepository;

    @BeforeEach
    void setup() {
        Stock stock = new Stock(12, "apple", "A", "A", 23.3, 25.49, 20.9, 24.34, 24.14, 22.34, 576, 14819, 4133);
        stockRepository.save(stock);
    }
    @AfterEach
    void tearDown() {
        stockRepository.deleteAll();
    }
    @Test
    void StockDetailsWithValidStockId() {
        long stockId = 12;
        Optional<Stock> optionalStock = stockServices.getStockDetailById(stockId);
        Stock stock = optionalStock.get();
        assertEquals(stock.getStockId(), stockId);
    }

    @Test
    void StocksDetailsWithInValidStockId(){

            long inValidId = 50032590;
            Optional<Stock> optionalStock = stockServices.getStockDetailById(inValidId);
            assertTrue(optionalStock.isEmpty());

    }


}