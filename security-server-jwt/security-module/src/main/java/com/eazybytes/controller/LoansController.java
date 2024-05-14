package com.eazybytes.controller;

import com.eazybytes.dto.LoansDTO;
import com.eazybytes.service.LoansService;
import lombok.AllArgsConstructor;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * The type Loans controller.
 */
@RestController
@AllArgsConstructor
public class LoansController {

    /**
     * The Loans service.
     */
    LoansService loansService;

    /**
     * Gets balance details.
     *
     * @param id the id
     * @return the balance details
     */
    @GetMapping("/v1/my-loans")
    public ResponseEntity<List<LoansDTO>> getLoans(@RequestParam String id) {
        List<LoansDTO> loansDTOS = loansService.findByCustomerId(id);
        if (loansDTOS.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(loansDTOS);
    }
}
