package com.example.Credit.System.repository;

import com.example.Credit.System.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>,QueryByExampleExecutor<Customer> {


    Optional<Customer> findCustomerByNationalId(String nationalId);








}
