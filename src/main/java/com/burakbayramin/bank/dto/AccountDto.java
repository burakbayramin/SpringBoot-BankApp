package com.burakbayramin.bank.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public record AccountDto(String id,
                         BigDecimal balance,
                         LocalDateTime creationDate,
                         CustomerDto customer,
                         Set<TransactionDto> transactions) {

}
