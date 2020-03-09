package com.enginakar.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.enginakar.models.Customer;
import com.enginakar.repos.CustomerRepository;
import com.enginakar.services.CustomerService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CustomerServiceTest {

	@Mock
	private CustomerRepository customerRepo;

	@InjectMocks
	private CustomerService customerService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void AddCustomer() {
		Customer customer = new Customer(1, "Jack Johnson", "1235236", "johnson@mail.com", "New York",
				"My mobile phone battery is broken");

		Customer testCustomer = customerService.addCustomer(customer);
		assertThat(testCustomer, is(customer));
		assertEquals(1, testCustomer.getId());
		assertThat(testCustomer.getName(), is("Jack Johnson"));
		assertThat(testCustomer.getPhoneNumber(), is("1235236"));
		assertThat(testCustomer.getEmail(), is("johnson@mail.com"));
		assertThat(testCustomer.getAddress(), is("New York"));
		assertThat(testCustomer.getDescription(), is("My mobile phone battery is broken"));
		verify(customerRepo, times(1)).save(customer);
	}
}