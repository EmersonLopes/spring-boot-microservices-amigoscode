package com.amigoscode.customer.controller;

import com.amigoscode.customer.dto.CustomerRequest;
import com.amigoscode.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("api/v1/customers")
@RestController
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRequest customerRequest) {
        log.info("New customer registration {}", customerRequest);
        customerService.registerUser(customerRequest);
    }
}
