package com.eazybytes.service;

import com.eazybytes.dto.ContactDTO;

import java.util.List;

public interface ContactService {
    List<ContactDTO> getContracts(String username);

    ContactDTO save(ContactDTO map);
}
