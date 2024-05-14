package com.eazybytes.repository;

import com.eazybytes.entity.model.Contact;
import org.hibernate.validator.internal.util.Contracts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {


    List<Contracts> findByContactEmail(String username);
}