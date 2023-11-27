package com.baidya.microservices.stockservice.util;

import com.baidya.microservices.stockservice.pojo.Stock;
import com.baidya.microservices.stockservice.repository.StockRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StockUtil {

    private final StockRepository stockRepository;

    public StockUtil(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Bean
    public CommandLineRunner loadDummyStockData(){
        Stock stock1 = new Stock(1L, "Reliance Small Cap", 110.12f);
        Stock stock2 = new Stock(2L, "Axis Large Cap", 80.11f);
        Stock stock3 = new Stock(3L, "HDFC Large Cap", 50.20f);
        return (args)->{
            stockRepository.save(stock1);
            stockRepository.save(stock2);
            stockRepository.save(stock3);
        };
    }
}
