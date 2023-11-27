package com.baidya.microservices.stockservice.configuration;

import com.baidya.microservices.stockservice.context.UserContextInterceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Configuration
public class StockConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
        if(interceptors == null){
           restTemplate.setInterceptors(Collections.singletonList(new UserContextInterceptors()));
        }else{
            interceptors.add(new UserContextInterceptors());
            restTemplate.setInterceptors(interceptors);
        }
        return restTemplate;
    }
}


