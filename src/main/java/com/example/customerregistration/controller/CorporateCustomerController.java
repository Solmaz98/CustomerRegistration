package com.example.customerregistration.controller;

import com.example.customerregistration.model.corporate.CorporateCustomerDto;
import com.example.customerregistration.service.CorporateCustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/corporate-api")

public class CorporateCustomerController {

    private final CorporateCustomerService customerService;

    public CorporateCustomerController(CorporateCustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("{customerId}")
    public CorporateCustomerDto getCorporateCustomerById(@PathVariable Integer customerId){
        return customerService.findById(customerId);
    }



    @GetMapping("")
    public List<CorporateCustomerDto> getCorporateCustomerList(){
        return customerService.findAll();
    }

    @GetMapping("/tin/{customerId}")
    public Integer returnTinNumber(@PathVariable Integer customerId){
        return customerService.getTinNumber(customerId);
    }

    @PostMapping("")
    public Integer saveCorporateCustomer(@RequestBody CorporateCustomerDto customerDto){
        return customerService.saveCustomer(customerDto);
    }

    @PutMapping("{customerId}")
    public void updateCustomer(@PathVariable Integer customerId ,@RequestBody CorporateCustomerDto customerDto ){
        customerService.updateCustomer(customerId ,customerDto);
    }

    @DeleteMapping("{customerId}")
    public void deleteCorporateCustomerById(@PathVariable Integer customerId){
        customerService.deleteCustomerById(customerId);
    }

}
