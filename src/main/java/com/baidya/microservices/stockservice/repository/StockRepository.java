package com.baidya.microservices.stockservice.repository;

import com.baidya.microservices.stockservice.pojo.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
}
