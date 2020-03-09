package com.enginakar.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enginakar.models.Customer;
import com.enginakar.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findByCustomer(Customer customer);
	
}
