package com.eazybytes.service;

import com.eazybytes.dto.CustomerDTO;

/**
 * The interface Auth service.
 */
public interface AuthService {
    /**
     * Create customer dto.
     *
     * @param customerDTO the customer dto
     * @return the customer dto
     */
    CustomerDTO create(CustomerDTO customerDTO);

    CustomerDTO getUer(String username);
}
