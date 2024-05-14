package com.eazybytes.service.impl;

import com.eazybytes.dto.ContactDTO;
import com.eazybytes.entity.model.Contact;
import com.eazybytes.repository.ContactRepository;
import com.eazybytes.service.ContactService;
import lombok.AllArgsConstructor;
import org.hibernate.validator.internal.util.Contracts;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import utils.StringUtils;

import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * The type Contact service.
 */
@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {

    /**
     * The Contact repository.
     */
    ContactRepository contactRepository;

    /**
     * The Model mapper.
     */
    ModelMapper modelMapper;

    @Override
    public List<ContactDTO> getContracts(String username) {
        if (StringUtils.isEmpty(username)) {
            return Collections.emptyList();
        }
        List<Contracts> contracts = contactRepository.findByContactEmail(username);
        return contracts.stream().map(c -> modelMapper.map(c, ContactDTO.class)).toList();
    }

    @Override
    public ContactDTO save(ContactDTO map) {
        Contact contact = modelMapper.map(map, Contact.class);
        contact.setCreateDt(new Date(System.currentTimeMillis()));
        contactRepository.save(contact);
        return modelMapper.map(contactRepository.save(contact), ContactDTO.class);
    }

    private String getServiceReqNumber() {
        Random random = new Random();
        int ranNum = random.nextInt(999999999 - 9999) + 9999;
        return "SR" + ranNum;
    }
}
