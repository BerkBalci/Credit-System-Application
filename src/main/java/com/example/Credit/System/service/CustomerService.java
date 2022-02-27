package com.example.Credit.System.service;

import com.example.Credit.System.model.Customer;
import com.example.Credit.System.model.dto.CustomerDTO;



import java.util.List;


public interface CustomerService  {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomer(Integer id);

    boolean addCustomer(Customer customer);

    CustomerDTO updateCustomer(Integer id,Customer customer);

    boolean deleteCustomer(Integer id);

    CustomerDTO findCustomerByNationalId(String nationalId);

    CustomerDTO Application(String nationalId);




}






