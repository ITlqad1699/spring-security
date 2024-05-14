package com.eazybytes.config.filter;

import constant.FieldNamesConstants;
import constant.SecurityConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static constant.SecurityConstants.EXPIRATION_TIME_MILLIS;
import static constant.SecurityConstants.ISSUER;

public class JWTTokenGeneratorFilter extends OncePerRequestFilter {

    private final Logger logger = LoggerFactory.getLogger(JWTTokenGeneratorFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            // JWT Generation Optimization
            Instant now = Instant.now();
            Instant expirationTime = now.plusMillis(EXPIRATION_TIME_MILLIS);
            // JWT Generation
            SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
            String jwt = Jwts.builder()
                    .issuer(ISSUER)
                    .subject("Bearer token")
                    .claim(FieldNamesConstants.USERNAME, authentication.getName())
                    .claim(FieldNamesConstants.AUTHORITIES, populateAuthorities(authentication.getAuthorities()))
                    .issuedAt(Date.from(now))
                    .expiration(Date.from(expirationTime))
                    .signWith(key)
                    .compact();
            // Response Setting
            response.setHeader(SecurityConstants.JWT_HEADER, jwt);
            request.setAttribute(SecurityConstants.JWT_HEADER, jwt);
            logger.info(String.format("Generated JWT token: %s", jwt));
        }

        filterChain.doFilter(request, response);
    }


    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return !request.getServletPath().equals("/v1/user");
    }

    private String populateAuthorities(Collection<? extends GrantedAuthority> collection) {
        Set<String> authoritiesSet = new HashSet<>();
        for (GrantedAuthority authority : collection) {
            authoritiesSet.add(authority.getAuthority());
        }
        return String.join(",", authoritiesSet);
    }
}
