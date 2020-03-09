package com.enginakar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.enginakar.models.Customer;
import com.enginakar.models.LandLinePhone;
import com.enginakar.models.Laptop;
import com.enginakar.models.MobilePhone;
import com.enginakar.models.Pc;
import com.enginakar.models.Product;
import com.enginakar.services.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping("/findCustomers")
	@ResponseBody
	public List<Customer> findCustomers() {
		return adminService.getCustomers();
	}

	@RequestMapping("/deleteCustomer/{id}")
	@ResponseBody
	public Customer delete(@PathVariable("id") int id) {
		return adminService.cancelCustomer(id);
	}

	@RequestMapping("/findProducts")
	@ResponseBody
	public List<Product> findProducts() {
		return adminService.getProducts();
	}

	@RequestMapping("/findProduct/{name}")
	@ResponseBody
	public Product findProduct(@PathVariable("name") String userName) throws Exception {
		return adminService.searchProduct(userName);
	}

	@RequestMapping("/laptopDetails")
	public String addLaptopDetails() {
		return "addLaptop";
	}

	@PostMapping(path = "/showLaptop", consumes = { "application/x-www-form-urlencoded" })
	public ModelAndView addNewLaptop(Laptop laptop) throws Exception {
		Product product = adminService.addNewProduct(laptop);
		ModelAndView mv = new ModelAndView("showLaptop");
		mv.addObject(product);
		return mv;
	}

	@RequestMapping("/pcDetails")
	public String addPcDetails() {
		return "addPc";
	}

	@PostMapping("/showPc")
	public ModelAndView addNewPc(Pc pc) throws Exception {
		Product product = adminService.addNewProduct(pc);
		ModelAndView mv = new ModelAndView("showPc");
		mv.addObject(product);
		return mv;
	}

	@RequestMapping("/mobilePhoneDetails")
	public String addMobilePhoneDetails() {
		return "addMobilePhone";
	}

	@PostMapping("/showMobilePhone")
	public ModelAndView addNewMobilePhone(MobilePhone mobilePhone) throws Exception {
		Product product = adminService.addNewProduct(mobilePhone);
		ModelAndView mv = new ModelAndView("showMobilePhone");
		mv.addObject(product);
		return mv;
	}

	@RequestMapping("/landLinePhoneDetails")
	public String addLandLineDetails() {
		return "addLandLinePhone";
	}

	@PostMapping("/showLandLinePhone")
	public ModelAndView addNewLandLinePhone(LandLinePhone landLinePhone) throws Exception {
		Product product = adminService.addNewProduct(landLinePhone);
		ModelAndView mv = new ModelAndView("showLandLinePhone");
		mv.addObject(product);
		return mv;
	}

	@RequestMapping("/deleteProduct/{id}")
	@ResponseBody
	public String deleteProduct(@PathVariable("id") int id) throws Exception {
		Product product = adminService.cancelProduct(id);
		return product.toString();
	}
}
