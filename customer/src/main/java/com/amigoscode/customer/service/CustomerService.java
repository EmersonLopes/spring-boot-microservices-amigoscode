package com.amigoscode.customer.service;

import com.amigoscode.customer.dto.CustomerRequest;
import com.amigoscode.customer.dto.FraudCheckResponse;
import com.amigoscode.customer.model.Customer;
import com.amigoscode.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RestTemplate restTemplate;

    public void registerUser(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .email(customerRequest.email())
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .build();

        customerRepository.saveAndFlush(customer);

        // todo: check if email is valid
        // todo: check if email not taken

        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        if(fraudCheckResponse.isFraudulent()){
            throw new IllegalStateException("Customer is fraudulent");
        }

    }
}
