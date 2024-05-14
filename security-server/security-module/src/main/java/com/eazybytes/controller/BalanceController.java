package com.eazybytes.controller;

import com.eazybytes.dto.TransactionDTO;
import com.eazybytes.service.BalanceService;
import lombok.AllArgsConstructor;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@AllArgsConstructor
public class BalanceController {

    BalanceService balanceService;

    @GetMapping("/my-balance")
    public ResponseEntity<List<TransactionDTO>> getBalanceDetails(@RequestParam String id) {
        List<TransactionDTO> accountTransactions = balanceService.findByCustomerId(id);
        if (accountTransactions.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(accountTransactions);
    }
}
