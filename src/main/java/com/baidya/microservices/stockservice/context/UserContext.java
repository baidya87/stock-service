package com.baidya.microservices.stockservice.context;

public class UserContext {
    private String clientRequestId;

    public String getClientRequestId() {
        return clientRequestId;
    }

    public void setClientRequestId(String clientRequestId) {
        this.clientRequestId = clientRequestId;
    }
}
