package com.example.BankManagement.dto;

import com.example.BankManagement.model.Transaction;
import com.example.BankManagement.model.TransactionType;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConvertor {
    public TransactionDto convert(Transaction from){
        return  new TransactionDto(from.getId(),
                from.getTransactionType(),
                from.getAmount(),
                from.getTransactionDate());
    }
}
