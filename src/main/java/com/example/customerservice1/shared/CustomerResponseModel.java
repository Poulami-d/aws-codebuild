package com.example.customerservice1.shared;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CustomerResponseModel {
    private String customerId;
    private String firstName;
    private String lastName;
    private double amount;
}
