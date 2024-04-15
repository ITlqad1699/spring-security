package com.eazybytes.entity.model;

import com.eazybytes.entity.DateAudit;
import com.eazybytes.entity.EntityBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "customer")
@Getter
@Setter
@AllArgsConstructor
public class Customer extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "customer_id")
    private Integer id;

    private String name;

    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String pwd;

    private String role;

    public Customer() {
    }

    public static class CustomerBuilder implements EntityBuilder<Customer> {
        private Integer id;
        private String name;
        private String email;
        private String mobileNumber;
        private String pwd;
        private String role;

        public static CustomerBuilder builder() {
            return new CustomerBuilder();
        }

        public CustomerBuilder setId(Integer id) {
            this.id = id;
            return this;
        }

        public CustomerBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CustomerBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public CustomerBuilder setPwd(String password) {
            this.pwd = password;
            return this;
        }

        public CustomerBuilder setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public CustomerBuilder setRole(String role) {
            this.role = role.isEmpty() ? "USER" : role;
            return this;
        }

        public Customer build() {
            return new Customer(id, name, email, mobileNumber, pwd, role);
        }
    }

}