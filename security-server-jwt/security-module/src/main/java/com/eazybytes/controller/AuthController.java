package com.eazybytes.controller;

import com.eazybytes.controller.vm.CustomerVM;
import com.eazybytes.dto.CustomerDTO;
import com.eazybytes.service.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Login controller.
 */
@RestController
@AllArgsConstructor
public class AuthController {

    /**
     * The Auth service.
     */
    AuthService authService;

    /**
     * The Model mapper.
     */
    ModelMapper modelMapper;

    /**
     * Register user response entity.
     *
     * @param customerVM the customer vm
     * @return the response entity
     */
    @PostMapping("/v1/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid CustomerVM customerVM) {
        CustomerDTO newCustomer = authService.create(modelMapper.map(customerVM, CustomerDTO.class));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("New customer has been created: " + newCustomer.getEmail());
    }

    /**
     * Gets user.
     *
     * @param authentication the authentication
     * @return the user
     */
    @GetMapping("/v1/user")
    public ResponseEntity<CustomerDTO> getUser(Authentication authentication) {
        String username = authentication.getName();
        CustomerDTO customer = authService.getUer(username);
        if (ObjectUtils.isEmpty(customer)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }
}
