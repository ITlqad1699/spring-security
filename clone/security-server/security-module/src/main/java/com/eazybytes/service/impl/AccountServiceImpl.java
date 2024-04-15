package com.eazybytes.service.impl;

import com.eazybytes.dto.AccountDTO;
import com.eazybytes.entity.model.Account;
import com.eazybytes.repository.AccountRepository;
import com.eazybytes.service.AccountService;
import constant.FieldNamesConstant;
import exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import utils.StringUtils;

import java.util.Optional;

/**
 * The type Account service.
 */
@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    /**
     * The Account repository.
     */
    AccountRepository accountRepository;

    /**
     * The Model mapper.
     */
    ModelMapper modelMapper;

    @Override
    public AccountDTO getAccount(String customerId) {

        if (StringUtils.isEmpty(customerId)) {
            return null;
        }
        Optional<Account> account = accountRepository.findByCustomerId(Integer.parseInt(customerId));
        if (account.isEmpty()) {
            throw new ResourceNotFoundException(Account.class.getSimpleName(),
                    FieldNamesConstant.CUSTOMER_ID, customerId);
        }
        return modelMapper.map(account.get(), AccountDTO.class);
    }
}
