package com.example.customerservice1.service;

import com.example.customerservice1.model.CustomerModel;
import com.example.customerservice1.shared.CustomerRequestModel;
import com.example.customerservice1.shared.CustomerResponseModel;

import java.util.List;

public interface CustomerService {
    public CustomerResponseModel createCustomer(CustomerRequestModel customerDetails);
    public List<CustomerModel> displayAllCustomer();
    public CustomerResponseModel findByCustomerId(String customerId);
    public Integer deleteByCustomerId(String customerId);
}
