package com.burakbayramin.bank.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String surname;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Account> accounts;

    
}
