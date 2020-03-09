package com.enginakar.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enginakar.models.Customer;

//@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Customer findByName(String name);

}
