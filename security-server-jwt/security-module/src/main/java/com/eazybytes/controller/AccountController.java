package com.eazybytes.controller;

import com.eazybytes.dto.AccountDTO;
import com.eazybytes.service.AccountService;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Account controller.
 */
@RestController
@AllArgsConstructor
public class AccountController {

    /**
     * The Account service.
     */
    AccountService accountService;

    /**
     * Gets my account.
     *
     * @param id the customer id
     * @return the my account
     */
    @GetMapping("/v1/my-account")
    public ResponseEntity<AccountDTO> getMyAccount(@RequestParam @Nullable String id) {
        AccountDTO accountDTO = accountService.getAccount(id);
        if (ObjectUtils.isEmpty(accountDTO)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(accountDTO);
    }
}
