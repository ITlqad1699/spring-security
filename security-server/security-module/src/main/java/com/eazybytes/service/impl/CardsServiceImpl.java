package com.eazybytes.service.impl;

import com.eazybytes.dto.CardsDTO;
import com.eazybytes.entity.model.Cards;
import com.eazybytes.repository.CardsRepository;
import com.eazybytes.service.CardsService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import utils.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * The type Cards service.
 */
@Service
@AllArgsConstructor
public class CardsServiceImpl implements CardsService {

    /**
     * The Cards repository.
     */
    CardsRepository cardsRepository;

    /**
     * The Model mapper.
     */
    ModelMapper modelMapper;

    @Override
    public List<CardsDTO> findByCustomerId(String customerId) {
        if (StringUtils.isEmpty(customerId)) {
            return Collections.emptyList();
        }

        List<Cards> cards = cardsRepository.findByCustomerId(Integer.valueOf(customerId));

        if (cards.isEmpty()) {
            return Collections.emptyList();
        }

        return cards.stream().map(card -> modelMapper.map(card, CardsDTO.class)).toList();
    }
}
