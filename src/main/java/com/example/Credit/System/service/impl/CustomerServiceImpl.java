package com.example.Credit.System.service.impl;

import com.example.Credit.System.model.Customer;
import com.example.Credit.System.model.dto.CustomerDTO;
import com.example.Credit.System.model.mapper.CustomerMapper;
import com.example.Credit.System.repository.CustomerRepository;
import com.example.Credit.System.service.CustomerService;



import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> all = customerRepository.findAll();
        return all.stream().map(CustomerMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomer(Integer id) {
        Optional<Customer> byId = customerRepository.findById(id);
        if (byId.isPresent()) {
            return CustomerMapper.toDto(byId.get());
        }
        return null;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 1500 + 1);
        customer.setCreditScore(randomNum);

        Customer save = customerRepository.save(customer);
        if (save == null)

            return false;
        return true;
    }

    @Override
    public CustomerDTO updateCustomer(Integer id, Customer customer) {
        CustomerDTO currentCustomer = getCustomer(id);
        if (currentCustomer == null)
            return null;
        customer.setId(id);
        return CustomerMapper.toDto(customerRepository.save(customer));

    }

    @Override
    public boolean deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
        return true;
    }

    @Override
    public CustomerDTO findCustomerByNationalId(String nationalId) {
        Optional<Customer> customer = customerRepository.findCustomerByNationalId(nationalId);
        if (customer.isPresent()) {
            return CustomerMapper.toDto(customer.get());
        }
        return null;
    }


    @Override
    public CustomerDTO Application(String nationalId) {
        Optional<Customer> customer = customerRepository.findCustomerByNationalId(nationalId);
        if (customer.isPresent()) {
           int monthlyIncome = customer.get().getMonthlyIncome();
           int score = customer.get().getCreditScore();
           customer.get().setCreditResult(applicationResult(score,monthlyIncome));
           customer.get().setCreditLimit(getCreditLine(score,monthlyIncome));
           customerRepository.save(customer.get());
            return CustomerMapper.toDto(customer.get());

        }
        return null;
    }

    private String applicationResult(Integer score, Integer monthlyIncome) {
            if(score < 500){
                return  "UNCONFIRMED";
            }else if(score >= 500 && score < 1000 && monthlyIncome.intValue() <= 5000){
                return "CONFIRMED";
            }else if(score >= 500 && score < 1000 && monthlyIncome.intValue() > 5000){
                 return "CONFIRMED";
            }else if(score >= 1000){
                 return  "CONFIRMED";
           }
           return "UNCONFIRMED";
    }

    private Integer getCreditLine(Integer score, Integer monthlyIncome) {
        if(score < 500){
            return 0;
        }else if(score >= 500 && score < 1000 && monthlyIncome.intValue() <= 5000){
            return 10000;
        }else if(score >= 500 && score < 1000 && monthlyIncome.intValue() > 5000){
            return 20000;
        }else if(score >= 1000){
            return  monthlyIncome*4;
        }
        return 0;
    }}








