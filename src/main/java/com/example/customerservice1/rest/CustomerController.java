package com.example.customerservice1.rest;

import com.example.customerservice1.model.CustomerModel;
import com.example.customerservice1.service.CustomerService;
import com.example.customerservice1.shared.CustomerRequestModel;
import com.example.customerservice1.shared.CustomerResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {

        this.customerService = customerService;
    }

    @PostMapping("/customers")
    public ResponseEntity<CustomerResponseModel> createCustomer(@RequestBody CustomerRequestModel customerRequestModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customerRequestModel));

    }
    @GetMapping(path = "/customers")
    public ResponseEntity<List<CustomerModel>> displayCustomers() {
        return ResponseEntity.ok(customerService.displayAllCustomer());
    }
    @GetMapping("/customers/customerId}")
    public ResponseEntity<CustomerResponseModel> getCustomerBycustomerId(@PathVariable("customerId") String customerId) {

       return ResponseEntity.status(HttpStatus.OK).body(customerService.findByCustomerId(customerId));

    }
    @DeleteMapping("/customers/customerId}")
    public ResponseEntity<Integer> deleteCustomer(@PathVariable("customerId") String customerId) {

        Integer result = customerService.deleteByCustomerId(customerId);
        return ResponseEntity.ok(result);

    }

}
