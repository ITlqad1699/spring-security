package com.eazybytes.service;

import com.eazybytes.dto.TransactionDTO;

import java.util.List;

public interface BalanceService {
    List<TransactionDTO> findByCustomerId(String customerId);
}
