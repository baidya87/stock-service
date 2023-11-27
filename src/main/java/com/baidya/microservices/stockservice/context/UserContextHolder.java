package com.baidya.microservices.stockservice.context;

import org.springframework.stereotype.Component;

@Component
public class UserContextHolder {

    private static final ThreadLocal<UserContext> threadLocal = new ThreadLocal<>();

    public static final UserContext getUserContext(){
        if(threadLocal.get()==null){
           UserContext userContext = new UserContext();
           threadLocal.set(userContext);
        }
        return threadLocal.get();
    }

}
