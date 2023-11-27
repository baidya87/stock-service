package com.baidya.microservices.stockservice.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Stock {
    @Id
    private long stockId;
    private String stockName;
    private float stockPrice;
}
