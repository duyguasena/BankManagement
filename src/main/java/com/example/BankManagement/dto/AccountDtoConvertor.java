package com.example.BankManagement.dto;

import com.example.BankManagement.model.Account;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class AccountDtoConvertor {

    private final CustomerDtoConvertor customerDtoConvertor;
    private final TransactionDtoConvertor transactionDtoConvertor;

    public AccountDtoConvertor(CustomerDtoConvertor customerDtoConvertor, TransactionDto transactionDto, TransactionDtoConvertor transactionDtoConvertor) {
        this.customerDtoConvertor = customerDtoConvertor;
        this.transactionDtoConvertor = transactionDtoConvertor;
    }

    public AccountDto convert (Account from){
        return new AccountDto(from.getId(),
                from.getBalance(),
                from.getCreationDate(),
                customerDtoConvertor.convertToAccountCustomer(from.getCustomer()),
                Objects.requireNonNull(from.getTransaction())
                        .stream()
                        .map(transactionDtoConvertor::convert)
                        .collect(Collectors.toSet()));

    }
}
