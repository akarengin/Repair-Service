package com.enginakar.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.enginakar.models.Computer;
import com.enginakar.models.Customer;
import com.enginakar.models.LandLinePhone;
import com.enginakar.models.Laptop;
import com.enginakar.models.MobilePhone;
import com.enginakar.models.Pc;
import com.enginakar.models.Phone;
import com.enginakar.models.Product;
import com.enginakar.repos.CustomerRepository;
import com.enginakar.repos.ProductRepository;

@Service
public class AdminService {

	@Autowired
	ProductRepository productRepo;

	@Autowired
	CustomerRepository customerRepo;

	public List<Customer> getCustomers() {
		return customerRepo.findAll();
	}

	public Customer cancelCustomer(int id) {
		Customer customer = customerRepo.getOne(id);
		if (customer != null) {
			customerRepo.delete(customer);
		}
		return customer;
	}

	/**
	 * Saves a given product to product repository. 
	 * It will specify which basic or specific part of the product 
	 * will be changed and determine the piece charge, 
	 * add to the service fee and end up with the price.
	 * @param product.
	 * @return the product
	 */
	public Product addNewProduct(Product product) {
		int pieceRate = 0;
		int serviceFee = product.getServiceFee();
		if (product instanceof Computer) {
			Computer computer = (Computer) product;
			computer.changedBasicPart(product);
			if (computer instanceof Laptop) {
				Laptop laptop = (Laptop) computer;
				laptop.changedSpecPart(product);
			} else {
				Pc pc = (Pc) computer;
				pc.changedSpecPart(product);
			}
			pieceRate = computer.pieceChargeAndFixedDate();
		} else {
			if (product instanceof Phone) {
				Phone phone = (Phone) product;
				phone.changedBasicPart(product);
				if (phone instanceof MobilePhone) {
					MobilePhone mobilePhone = (MobilePhone) phone;
					mobilePhone.changedSpecPart(product);
				} else {
					LandLinePhone landLinePhone = (LandLinePhone) phone;
					landLinePhone.changedSpecPart(product);
				}
				pieceRate = phone.pieceChargeAndFixedDate();
			}
		}
		product.calculatePrice(serviceFee, pieceRate);
		productRepo.save(product);
		return product;
	}

	public List<Product> getProducts() {
		return productRepo.findAll();
	}

	public Product searchProduct(String name) {
		Customer customer = customerRepo.findByName(name);
		return productRepo.findByCustomer(customer);
	}

	public Product cancelProduct(int id) {
		Product product = productRepo.getOne(id);
		productRepo.deleteById(id);
		return product;
	}
}
