package com.example.customerregistration.controller;


import com.example.customerregistration.model.IndividualCustomerDto;
import com.example.customerregistration.service.CustomerService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/individual-api")

public class IndividualCustomerController {

    private final CustomerService customerService;

    public IndividualCustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/{customerId}",produces = "application/json")
    public IndividualCustomerDto getCustomerById(@PathVariable Integer customerId){
        return customerService.findById(customerId);
    }

    @GetMapping
    public List<IndividualCustomerDto> getCustomersAll(){
        return customerService.findAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Integer saveCustomer(@Valid @RequestBody IndividualCustomerDto customersDto){
        return customerService.saveCustomer(customersDto);
    }


    @PutMapping("{customerId}")
    public void updateCustomer(@PathVariable Integer customerId ,@RequestBody IndividualCustomerDto customersDto){
         customerService.updateCustomer(customerId ,customersDto);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable Integer customerId){
        customerService.deleteCustomerById(customerId);
    }
}
