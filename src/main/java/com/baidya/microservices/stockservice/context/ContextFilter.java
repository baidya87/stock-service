package com.baidya.microservices.stockservice.context;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ContextFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(ContextFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //logger.info("inside doFilter(..)");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        UserContext userContext = UserContextHolder.getUserContext();
        userContext.setClientRequestId(httpServletRequest.getHeader("clientRequestId"));
        logger.info("Received clientRequestId {} from thread {}", userContext.getClientRequestId(), Thread.currentThread().getId());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
