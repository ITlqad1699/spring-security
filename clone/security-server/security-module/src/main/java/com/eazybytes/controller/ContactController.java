package com.eazybytes.controller;

import com.eazybytes.controller.vm.ContactVM;
import com.eazybytes.dto.ContactDTO;
import com.eazybytes.service.ContactService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ContactController {

    ContactService contactService;

    ModelMapper modelMapper;

    @GetMapping("/contact")
    public ResponseEntity<List<ContactDTO>> getContact(@RequestParam String username) {
        List<ContactDTO> contactDTOS = contactService.getContracts(username);
        if (contactDTOS.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contactDTOS);
    }

    @PostMapping("/contact")
    public ResponseEntity<ContactDTO> saveContactInquiryDetails(@RequestBody ContactVM contactVM) {
        ContactDTO contactDTO = contactService.save(modelMapper.map(contactVM, ContactDTO.class));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(contactDTO);
    }

}
