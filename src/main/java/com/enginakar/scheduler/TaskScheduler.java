package com.enginakar.scheduler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.enginakar.models.Customer;
import com.enginakar.models.Product;
import com.enginakar.repos.ProductRepository;

@Component
public class TaskScheduler {

	private static Calendar currentDate = Calendar.getInstance();

	@Autowired
	ProductRepository productRepo;

	private static final Logger log = LoggerFactory.getLogger(TaskScheduler.class);

	@Scheduled(fixedDelay = 5000, initialDelay = 5000)
	public void taskSchedular() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		currentDate.add(Calendar.MONTH, 1);
		List<Product> list = productRepo.findAll();
		for (Product product : list) {
			if (dateFormat.format(product.getRepairDate()).equals((dateFormat.format(currentDate.getTime())))) {
				Customer customer = product.getCustomer();
				String productType = product.getClass().getSimpleName();
				productType = productType.substring(0, 1).toLowerCase() + productType.substring(1);
				log.info(customer.getName() + ", your " + productType + " " + product.getPiece() + " repair date has come.");
			}
		}
	}
}
