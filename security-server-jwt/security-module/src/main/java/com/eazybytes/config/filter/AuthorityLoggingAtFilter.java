package com.eazybytes.config.filter;

import jakarta.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;

public class AuthorityLoggingAtFilter implements Filter {

    private final Logger logger = LoggerFactory.getLogger(AuthorityLoggingAtFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            logger.info("Authentication Validation is in progress");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}