package com.eazybytes.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private String email;
    private String pwd;
    private String role;
    private String name;
    private String mobileNumber;
}
