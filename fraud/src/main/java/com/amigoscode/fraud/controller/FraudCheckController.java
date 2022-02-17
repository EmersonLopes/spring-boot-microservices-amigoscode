package com.amigoscode.fraud.controller;


import com.amigoscode.fraud.model.FraudCheckResponse;
import com.amigoscode.fraud.service.FraudCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudCheckController {

    @Autowired
    private FraudCheckService fraudCheckService;

    @GetMapping("{customerId}")
    private FraudCheckResponse isCustomerFraudulent(@PathVariable("customerId") Integer customerId){
        boolean fraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(fraudulentCustomer);

    }

}
