package com.example.Credit.System.model.mapper;

import com.example.Credit.System.model.Customer;
import com.example.Credit.System.model.dto.CustomerDTO;

public class CustomerMapper {

    public static CustomerDTO toDto(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setNationalId(customer.getNationalId());
        customerDTO.setName(customer.getName());
        customerDTO.setSurname(customer.getSurname());
        customerDTO.setMonthlyIncome(customer.getMonthlyIncome());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());
        customerDTO.setCreditScore(customer.getCreditScore());
        customerDTO.setCreditResult(customer.getCreditResult());
        customerDTO.setCreditLimit(customer.getCreditLimit());
        return customerDTO;

    }

    public static Customer toEntity(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setNationalId(customerDTO.getNationalId());
        customer.setName(customerDTO.getName());
        customer.setSurname(customerDTO.getSurname());
        customer.setMonthlyIncome(customerDTO.getMonthlyIncome());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setCreditScore(customerDTO.getCreditScore());
        customer.setCreditResult(customerDTO.getCreditResult());
        customer.setCreditLimit(customerDTO.getCreditLimit());
        return customer;

    }
}
