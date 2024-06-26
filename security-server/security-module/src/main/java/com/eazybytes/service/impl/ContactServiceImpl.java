package com.eazybytes.service.impl;

import com.eazybytes.dto.ContactDTO;
import com.eazybytes.entity.model.Contact;
import com.eazybytes.repository.ContactRepository;
import com.eazybytes.service.ContactService;
import exception.SystemErrorException;
import lombok.AllArgsConstructor;
import org.hibernate.validator.internal.util.Contracts;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import utils.StringUtils;

import java.sql.Date;
import java.util.Collections;
import java.util.List;

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
		
		if (contracts.isEmpty()) {
			return Collections.emptyList();
		}
		return contracts.stream().map(c -> modelMapper.map(c, ContactDTO.class)).toList();
	}
	
	@Override
	public ContactDTO save(ContactDTO contactDTO) {
		try {
			Contact contact = modelMapper.map(contactDTO, Contact.class);
			contact.setCreateDt(new Date(System.currentTimeMillis()));
			return modelMapper.map(contactRepository.save(contact), ContactDTO.class);
		} catch (Exception e) {
			throw new SystemErrorException();
		}
		
	}
}
