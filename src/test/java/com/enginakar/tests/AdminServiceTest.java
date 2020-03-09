package com.enginakar.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.Date;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.enginakar.models.Customer;
import com.enginakar.models.Product;
import com.enginakar.repos.CustomerRepository;
import com.enginakar.repos.ProductRepository;
import com.enginakar.services.AdminService;
import com.enginakar.services.CustomerService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class AdminServiceTest {

	@Mock
	private CustomerRepository customerRepo;

	@Mock
	private ProductRepository productRepo;

	@InjectMocks
	private AdminService adminService;

	@InjectMocks
	private CustomerService customerService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getCustomers() {
		Customer customer1 = new Customer(1, "Jason Robert", "874520", "jason@mail.com", "Utah",
				"My laptop screen is broken");
		Customer customer2 = new Customer(2, "Julia Richardson", "02394230", "julia@mail.com", "Utah",
				"My pc computer box is broken");
		when(customerRepo.findAll()).thenReturn(Arrays.asList(customer1, customer2));
		assertThat(adminService.getCustomers().size(), is(2));
		assertThat(adminService.getCustomers().get(0), is(customer1));
		assertThat(adminService.getCustomers().get(1), is(customer2));
		verify(customerRepo, times(3)).findAll();
	}

	@Test
	public void cancelCustomer() {
		Customer customer1 = new Customer(1, "Tom Sally", "94638234", "tom@mail.com", "Chicago",
				"My landline receiver is broken");
		Customer testCustomer = customerService.addCustomer(customer1);
		assertEquals(null, adminService.cancelCustomer(testCustomer.getId()));
		assertEquals(null, adminService.cancelCustomer(10));
	}

	@Test
	public void addNewProduct() {
		Customer customer1 = new Customer(1, "Nancy Cindy", "34713941", "nancy@mail.com", "Los Angeles",
				"My pc screen is broken");
		customerService.addCustomer(customer1);
		Date d1 = new Date("2020/03/08");
		Date d2 = new Date("2021/03/08");
		Product product = new Product(1, "Asus", 100, "screen", d1, d2, 300, customer1);
		Product testProduct = adminService.addNewProduct(product);
		assertEquals(testProduct, product);
		assertEquals(1, testProduct.getId());
	}

}