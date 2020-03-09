package com.enginakar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.enginakar.models.Customer;
import com.enginakar.repos.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepo;
	
	public Customer addCustomer(Customer customer) {
		customerRepo.save(customer);
		return customer;
	}
}
