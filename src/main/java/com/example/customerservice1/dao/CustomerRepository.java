package com.example.customerservice1.dao;

import com.example.customerservice1.model.CustomerModel;
import com.example.customerservice1.shared.CustomerResponseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel,Integer> {
    @Query
    public CustomerResponseModel findByCustomerId(String customerId);

    @Query
    public Integer deleteByCustomerId(String customerId);


}
