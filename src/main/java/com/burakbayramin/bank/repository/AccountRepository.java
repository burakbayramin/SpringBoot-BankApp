package com.burakbayramin.bank.repository;

import com.burakbayramin.bank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
