package com.example.BankManagement.dto

import com.example.BankManagement.model.Customer
import java.math.BigDecimal
import java.time.LocalDateTime

data class AccountDto(
    val id:String?,
    val balance: BigDecimal?,
    val creationDate: LocalDateTime,
    val customer: AccountCustomerDto?,
    val transaction:Set<TransactionDto>
)
