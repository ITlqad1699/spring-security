package com.eazybytes.service;

import com.eazybytes.dto.AccountDTO;

/**
 * The interface Account service.
 */
public interface AccountService {
    /**
     * Gets account.
     *
     * @param id the id
     * @return the account
     */
    AccountDTO getAccount(String id);
}
