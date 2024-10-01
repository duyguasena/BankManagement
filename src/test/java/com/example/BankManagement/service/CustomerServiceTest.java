package com.example.BankManagement.service;

import com.example.BankManagement.dto.CustomerDtoConvertor;
import com.example.BankManagement.model.Customer;
import com.example.BankManagement.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class CustomerServiceTest {
    private CustomerService service;
    private CustomerRepository customerRepository;
    private CustomerDtoConvertor convertor;

    @BeforeEach
    public void setUp(){
        customerRepository=mock(CustomerRepository.class);
        convertor=mock(CustomerDtoConvertor.class);
        service=new CustomerService(customerRepository,convertor);
    }

    @Test
    public void testFindByCustomerId_whenCustomerIdExist_shouldReturnCustomer(){
        Customer customer=new Customer("id","name","surname", Set.of());

        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.of(customer));

        Customer result=service.findCustomerById("id");

        assertEquals(result,customer);
    }
}
