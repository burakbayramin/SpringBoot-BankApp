package com.burakbayramin.bank.service;

import com.burakbayramin.bank.dto.AccountDto;
import com.burakbayramin.bank.dto.CreateAccountRequest;
import com.burakbayramin.bank.model.Account;
import com.burakbayramin.bank.model.Customer;
import com.burakbayramin.bank.model.Transaction;
import com.burakbayramin.bank.repository.AccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;


    private final ModelMapper modelMapper;

    public AccountService(AccountRepository accountRepository, CustomerService customerService, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;

        this.modelMapper = modelMapper;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());

        Account account = new Account(
                createAccountRequest.getInitialCredit(),
                LocalDateTime.now(),
                customer
        );

        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
            Transaction transaction = new Transaction(createAccountRequest.getInitialCredit(),LocalDateTime.now(), account);
            account.getTransactions().add(transaction);
        }

        Account newAccount = accountRepository.save(account);
        AccountDto accountDto = modelMapper.map(newAccount, AccountDto.class);

        return accountDto;
    }
}
