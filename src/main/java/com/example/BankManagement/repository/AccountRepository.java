package com.example.BankManagement.repository;

import com.example.BankManagement.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
}
