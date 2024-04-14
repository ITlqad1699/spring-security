package com.eazybytes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
//If you want to load another repository outside the main package use:
//@EnableJpaRepositories("com.eazybytes.repository")
//If you want to scan entities(models) outside the main package use:
//@EntityScan("com.eazybytes.entity")
@EnableWebSecurity //Optional if you want to enable all features of spring security
public class EazyBankBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EazyBankBackendApplication.class, args);
    }

}
