package com.eazybytes.service.impl;

import com.eazybytes.dto.TransactionDTO;
import com.eazybytes.entity.model.AccountTransactions;
import com.eazybytes.repository.AccountTransactionsRepository;
import com.eazybytes.service.BalanceService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import utils.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * The type Balance service.
 */
@Service
@AllArgsConstructor
public class BalanceServiceImpl implements BalanceService {
    /**
     * The Account transactions repository.
     */
    AccountTransactionsRepository accountTransactionsRepository;

    /**
     * The Model mapper.
     */
    ModelMapper modelMapper;

    @Override
    public List<TransactionDTO> findByCustomerId(String customerId) {
        if (StringUtils.isEmpty(customerId)) {
            return Collections.emptyList();
        }
        List<AccountTransactions> accountTransactions =
                accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(Integer.parseInt(customerId));
        return accountTransactions.stream().map(transaction -> modelMapper.map(transaction, TransactionDTO.class)).toList();
    }
}
