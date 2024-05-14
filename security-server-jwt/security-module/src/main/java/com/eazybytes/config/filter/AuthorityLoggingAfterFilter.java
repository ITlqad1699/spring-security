package com.eazybytes.config.filter;

import jakarta.servlet.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;

public class AuthorityLoggingAfterFilter implements Filter {

    private static final Log LOG = LogFactory.getLog(AuthorityLoggingAfterFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            LOG.info("User: " + authentication.getName() + " is successfully authenticated" +
                    " and has the authorities " + authentication.getAuthorities().toString());
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
