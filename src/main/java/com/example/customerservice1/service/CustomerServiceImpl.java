package com.example.customerservice1.service;
import com.example.customerservice1.dao.CustomerRepository;
import com.example.customerservice1.model.CustomerModel;
import com.example.customerservice1.shared.CustomerRequestModel;
import com.example.customerservice1.shared.CustomerResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
@Service
public class CustomerServiceImpl implements CustomerService{
    private ModelMapper modelMapper;
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(ModelMapper modelMapper, CustomerRepository customerRepository) {
        this.modelMapper = modelMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponseModel createCustomer(CustomerRequestModel customerDetails) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CustomerModel model=modelMapper.map(customerDetails,CustomerModel.class);
        model.setCustomerId(UUID.randomUUID().toString());
        CustomerModel response=customerRepository.save(model);
        return modelMapper.map(response,CustomerResponseModel.class);
    }

    @Override
    public List<CustomerModel> displayAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerResponseModel findByCustomerId(String customerId) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CustomerResponseModel model = customerRepository.findByCustomerId(customerId);
        CustomerResponseModel response = modelMapper.map(model,CustomerResponseModel.class);
        return response;
    }

    @Override
    public Integer deleteByCustomerId(String customerId) {
        return customerRepository.deleteByCustomerId(customerId);
    }


}
