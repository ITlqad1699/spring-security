package com.eazybytes.controller;

import com.eazybytes.dto.CardsDTO;
import com.eazybytes.service.CardsService;
import lombok.AllArgsConstructor;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * The type Cards controller.
 */
@RestController
@AllArgsConstructor
public class CardsController {

    CardsService cardsService;

    /**
     * Gets my account.
     *
     * @return the my account
     */
    @GetMapping("/my-cards")
    public ResponseEntity<List<CardsDTO>> getMyAccount(@RequestParam String id) {
        List<CardsDTO> cardsDTOS = cardsService.findByCustomerId(id);

        if (cardsDTOS.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(cardsDTOS);
    }
}
