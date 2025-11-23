package com.angel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angel.entities.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String>{

}
