package com.eazybytes.service.impl;

import com.eazybytes.dto.CustomerDTO;
import com.eazybytes.entity.model.Account;
import com.eazybytes.entity.model.Customer;
import com.eazybytes.entity.model.Customer.CustomerBuilder;
import com.eazybytes.repository.CustomerRepository;
import com.eazybytes.service.AuthService;
import constant.FieldNamesConstants;
import exception.EmailAlreadyExistsException;
import exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import utils.StringUtils;

import java.util.Optional;

/**
 * The type Auth service.
 */
@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    /**
     * The Model mapper.
     */
    ModelMapper modelMapper;
    /**
     * The Customer repository.
     */
    CustomerRepository customerRepository;
    /**
     * The Password encoder.
     */
    PasswordEncoder passwordEncoder;

    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmail(customerDTO.getEmail());
        optionalCustomer.ifPresent(c -> {
            throw new EmailAlreadyExistsException("Email already exists");
        });
        Customer customer = CustomerBuilder.builder()
                .setEmail(customerDTO.getEmail())
                .setPwd(passwordEncoder.encode(customerDTO.getPwd()))
                .setRole(customerDTO.getRole())
                .setName(customerDTO.getName())
                .setMobileNumber(customerDTO.getMobileNumber())
                .build();
        return modelMapper.map(customerRepository.save(customer), CustomerDTO.class);
    }

    @Override
    public CustomerDTO getUer(String username) {
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        Optional<Customer> customer = customerRepository.findByEmail(username);
        if (customer.isEmpty()) {
            throw new ResourceNotFoundException(Account.class.getSimpleName(), FieldNamesConstants.USERNAME, username);
        }

        return modelMapper.map(customer, CustomerDTO.class);
    }
}
