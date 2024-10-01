package com.example.BankManagement.dto;

import com.example.BankManagement.model.Account;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CustomerAccountDtoConvertor {

    private final TransactionDtoConvertor transactionDtoConvertor;

    public CustomerAccountDtoConvertor(TransactionDtoConvertor transactionDtoConvertor) {
        this.transactionDtoConvertor = transactionDtoConvertor;
    }

    public CustomerAccountDtoConvertor convert(Account from){
        return new CustomerAccountDto(
                Objects.requireNonNull(from.getId()),
                from.getBalance(),
                from.getTransaction().stream().map(transactionDtoConvertor::convert).collect(Collectors.toSet()),
                from.getCreationDate());

    }
}
