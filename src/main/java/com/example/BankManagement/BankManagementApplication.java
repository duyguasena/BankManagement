package com.example.BankManagement;

import com.example.BankManagement.model.Customer;
import com.example.BankManagement.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

@SpringBootApplication
public class BankManagementApplication implements CommandLineRunner {

	private final CustomerRepository customerRepository;

    public BankManagementApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(BankManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer customer=customerRepository.save(new Customer("","Duygu","Kaya",new HashSet<>()));
		System.out.println(customer);

	}
}
