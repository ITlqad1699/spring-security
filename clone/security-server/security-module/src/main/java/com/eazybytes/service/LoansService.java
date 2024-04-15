package com.eazybytes.service;

import com.eazybytes.dto.LoansDTO;

import java.util.List;

public interface LoansService {
    List<LoansDTO> findByCustomerId(String id);
}
