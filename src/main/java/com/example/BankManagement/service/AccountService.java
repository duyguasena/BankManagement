package com.example.BankManagement.service;

import com.example.BankManagement.dto.AccountDto;
import com.example.BankManagement.dto.AccountDtoConvertor;
import com.example.BankManagement.dto.CreateAccountRequest;
import com.example.BankManagement.model.Account;
import com.example.BankManagement.model.Customer;
import com.example.BankManagement.model.Transaction;
import com.example.BankManagement.repository.AccountRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {
    private  final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountDtoConvertor convertor;

    public AccountService(AccountRepository accountRepository,
                          CustomerService customerService,
                          AccountDtoConvertor convertor) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.convertor = convertor;
    }

    public AccountDto createAccount(CreateAccountRequest createaAccountRequest){
        Customer customer=customerService.findCustomerById(createaAccountRequest.getCustomerId());

        Account acount=new Account(
                customer,
                createaAccountRequest.getInitialCredit(),
                LocalDateTime.now());

        if (createaAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO)>0){
            Transaction transaction=new Transaction(createaAccountRequest.getInitialCredit(),acount);
            acount.getTransaction().add(transaction)
        }
        return convertor.convert(accountRepository.save(acount));
    }
}
