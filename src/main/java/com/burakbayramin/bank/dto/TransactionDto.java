package com.burakbayramin.bank.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionDto(String id,
                             BigDecimal account,
                             LocalDateTime transactionDate) {
}
