package com.example.BankManagement.repository;

import com.example.BankManagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String > {
}
