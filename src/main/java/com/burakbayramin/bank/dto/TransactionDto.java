package com.burakbayramin.bank.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDto {
    private String name;
    private BigDecimal account;
    private LocalDateTime transactionDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAccount() {
        return account;
    }

    public void setAccount(BigDecimal account) {
        this.account = account;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}
