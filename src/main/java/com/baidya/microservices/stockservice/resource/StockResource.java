package com.baidya.microservices.stockservice.resource;

import com.baidya.microservices.stockservice.pojo.Stock;
import com.baidya.microservices.stockservice.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("stocks")
public class StockResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(StockResource.class);

    private final StockService stockService;

    @Autowired
    private Environment environment;

    public StockResource(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String test(){
        LOGGER.info("Market START {} END {}", environment.getProperty("stock.start.time"), environment.getProperty("stock.end.time"));
        return String.format("Market start time %s & end time %s", environment.getProperty("stock.start.time"), environment.getProperty("stock.end.time"));
    }

    @GetMapping(value = "/{id}")
    public Stock getById(@PathVariable("id") long id){
        LOGGER.info("Server PORT: {}", environment.getProperty("server.port"));
        return stockService.fetchById(id);
    }
    @GetMapping
    public List<Stock> getAll(){
        LOGGER.info("Server PORT: {}", environment.getProperty("server.port"));
        return stockService.fetchAll();
    }
}
