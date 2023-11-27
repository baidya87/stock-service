package com.baidya.microservices.stockservice.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
public class UserContextInterceptors implements ClientHttpRequestInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserContextInterceptors.class);
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        HttpHeaders httpHeaders = request.getHeaders();
        httpHeaders.add("clientRequestId", UserContextHolder.getUserContext().getClientRequestId());
        LOGGER.info("Setting UP client request Id");
        return execution.execute(request, body);
    }
}
