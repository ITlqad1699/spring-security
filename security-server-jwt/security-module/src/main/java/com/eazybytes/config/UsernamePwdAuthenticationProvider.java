package com.eazybytes.config;

import com.eazybytes.entity.model.Authority;
import com.eazybytes.entity.model.Customer;
import com.eazybytes.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * The type Username pwd authentication provider.
 */
@Component
@AllArgsConstructor
public class UsernamePwdAuthenticationProvider implements AuthenticationProvider {

    /**
     * The Customer repository.
     */
    CustomerRepository customerRepository;
    /**
     * The Password encoder.
     */
    PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        Optional<Customer> customer = customerRepository.findByEmail(username);

        if (customer.isPresent()) {
            if (passwordEncoder.matches(pwd, customer.get().getPwd())) {
                return new UsernamePasswordAuthenticationToken(username, pwd,
                        getGrantedAuthorities(customer.get().getAuthorities()));
            } else {
                throw new BadCredentialsException("Invalid credentials");
            }
        } else {
            throw new BadCredentialsException("No user registered with this details");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

    private List<GrantedAuthority> getGrantedAuthorities(Set<Authority> authorities) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for (Authority authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        }

        return grantedAuthorities;
    }
}
