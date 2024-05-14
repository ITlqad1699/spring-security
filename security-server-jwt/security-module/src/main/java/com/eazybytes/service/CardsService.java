package com.eazybytes.service;

import com.eazybytes.dto.CardsDTO;

import java.util.List;

/**
 * The interface Cards service.
 */
public interface CardsService {
    /**
     * Find by customer id list.
     *
     * @param customerId the customer id
     * @return the list
     */
    List<CardsDTO> findByCustomerId(String customerId);
}
