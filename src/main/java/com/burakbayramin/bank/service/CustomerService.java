package com.burakbayramin.bank.service;

import com.burakbayramin.bank.dto.CustomerDto;
import com.burakbayramin.bank.exception.CustomerNotFoundException;
import com.burakbayramin.bank.model.Customer;
import com.burakbayramin.bank.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerService(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    protected Customer findCustomerById(String id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException("Customer couldn't find by id " + id)
        );
    }

    public CustomerDto getCustomerById(String customerId) {

    }
}
