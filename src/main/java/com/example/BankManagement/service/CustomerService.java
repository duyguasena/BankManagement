package com.example.BankManagement.service;

import com.example.BankManagement.dto.CustomerDto;
import com.example.BankManagement.dto.CustomerDtoConvertor;
import com.example.BankManagement.exception.CustomerNotFoundException;
import com.example.BankManagement.model.Customer;
import com.example.BankManagement.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConvertor customerDtoConvertor;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConvertor customerDtoConvertor) {
        this.customerRepository = customerRepository;
        this.customerDtoConvertor = customerDtoConvertor;
    }

    protected Customer findCustomerById(String id){
        return customerRepository.findById(id)
                .orElseThrow(()->new CustomerNotFoundException("Customer could not found by id:"+id));
    }

    public CustomerDto getCustomerById(String customerId) {
        return customerDtoConvertor.convertToCustomerDto(getCustomerById(customerId));

    }
}
