package com.enginakar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.enginakar.models.Customer;
import com.enginakar.services.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

	@RequestMapping("/repairService")
	public String formFailureLogging() {
		return "form";
	}
	
	@PostMapping(path="/enroll",consumes = {"application/x-www-form-urlencoded"})
	public ModelAndView addNewCustomer(Customer customer) {
		customerService.addCustomer(customer);
		ModelAndView mv = new ModelAndView("welcome");
		mv.addObject(customer);
		return mv;
	}
}
