package com.burakbayramin.bank.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private BigDecimal balance;

    private LocalDateTime creationDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private Set<Transaction> transaction;

    public Account() {
    }

    public Account(String id, BigDecimal balance, LocalDateTime creationDate, Customer customer, Set<Transaction> transaction) {
        this.id = id;
        this.balance = balance;
        this.creationDate = creationDate;
        this.customer = customer;
        this.transaction = transaction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(Set<Transaction> transaction) {
        this.transaction = transaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;

        if (getId() != null ? !getId().equals(account.getId()) : account.getId() != null) return false;
        if (getBalance() != null ? !getBalance().equals(account.getBalance()) : account.getBalance() != null)
            return false;
        if (getCreationDate() != null ? !getCreationDate().equals(account.getCreationDate()) : account.getCreationDate() != null)
            return false;
        if (getCustomer() != null ? !getCustomer().equals(account.getCustomer()) : account.getCustomer() != null)
            return false;
        return getTransaction() != null ? getTransaction().equals(account.getTransaction()) : account.getTransaction() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getBalance() != null ? getBalance().hashCode() : 0);
        result = 31 * result + (getCreationDate() != null ? getCreationDate().hashCode() : 0);
        result = 31 * result + (getCustomer() != null ? getCustomer().hashCode() : 0);
        return result;
    }
}
