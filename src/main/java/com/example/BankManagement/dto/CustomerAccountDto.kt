package com.example.BankManagement.dto

import java.math.BigDecimal
import java.time.LocalDateTime

data class CustomerAccountDto(
    val id:String?,
    val balance: BigDecimal?=BigDecimal.ZERO,
    val creationDate: LocalDateTime,
    val transaction:Set<TransactionDto>
)
