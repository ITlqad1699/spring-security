package com.eazybytes.service.impl;

import com.eazybytes.dto.LoansDTO;
import com.eazybytes.entity.model.Loans;
import com.eazybytes.repository.LoanRepository;
import com.eazybytes.service.LoansService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import utils.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * The type Loans service.
 */
@Service
@AllArgsConstructor
public class LoansServiceImpl implements LoansService {

    /**
     * The Loan repository.
     */
    LoanRepository loanRepository;

    /**
     * The Model mapper.
     */
    ModelMapper modelMapper;

    @Override
    public List<LoansDTO> findByCustomerId(String customerId) {
        if (StringUtils.isEmpty(customerId)) {
            return Collections.emptyList();
        }
        List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(Integer.parseInt(customerId));
        return loans.stream().map(loan -> modelMapper.map(loan, LoansDTO.class)).toList();
    }
}
