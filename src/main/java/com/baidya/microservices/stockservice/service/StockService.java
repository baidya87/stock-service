package com.baidya.microservices.stockservice.service;

import com.baidya.microservices.stockservice.pojo.Stock;
import com.baidya.microservices.stockservice.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> fetchAll() {
        return stockRepository.findAll();
    }

    public Stock fetchById(long id) {
        Stock stock = stockRepository.findById(id).orElse(null);
        if(stock == null) throw new RuntimeException("Stock with ID = %d, NOT FOUND");
        return stock;
    }
}
