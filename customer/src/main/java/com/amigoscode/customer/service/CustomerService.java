package com.amigoscode.customer.service;

import com.amigoscode.customer.dto.CustomerRequest;
import com.amigoscode.customer.model.Customer;
import com.amigoscode.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void registerUser(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .email(customerRequest.email())
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .build();

        // todo: check if email is valid
        // todo: check if email not taken

        customerRepository.save(customer);

    }
}
