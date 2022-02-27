package com.example.Credit.System.service.impl;

import com.example.Credit.System.model.Customer;
import com.example.Credit.System.model.dto.CustomerDTO;
import com.example.Credit.System.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @BeforeClass
    public void setup(){


    }

    @Test
    void getAllCustomers() {

        Customer customer1 = new Customer(1,"32137263421", "Customer1", "Lastname1",10000,"05554443322",300,"UNCONFIRMED",0);
        Customer customer2 = new Customer(1,"32137263421", "Customer2", "Lastname2",5000,"05435652121",800,"CONFIRMED",20000);
        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);

        // stub - when
        when(customerRepository.findAll()).thenReturn(customers);

        // then
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();

        Assert.assertEquals(customers.size(), allCustomers.size());
    }


    @Test
    void getCustomer() {

        // init step
        Customer expectedCustomer = new Customer(1,"32137263421", "Customer1", "Lastname1",10000,"05554443322",300,"UNCONFIRMED",0);

        // stub - when step
        Optional<Customer> expectedOptCustomer = Optional.of(expectedCustomer);
        when(customerRepository.findById(1)).thenReturn(expectedOptCustomer);

        // then step
        CustomerDTO actualCustomer = customerService.getCustomer(1);

        // valid step
        assertEquals(expectedCustomer, actualCustomer);
    }

    @Test
    void addCustomer() {

        // init
        Customer expectedCustomer = new Customer(1,"32137263421", "Customer1", "Lastname1",10000,"05554443322",300,"UNCONFIRMED",0);

        // stub - when
        when(customerRepository.save(expectedCustomer)).thenReturn(expectedCustomer);

        // then
        customerService.addCustomer(expectedCustomer);



        verify(customerRepository, times(1)).save(expectedCustomer);
    }

    @Test
    void updateCustomer() {
    }

    @Test
    void deleteCustomer() {
    }

    @Test
    void findCustomerByNationalId() {
    }
}