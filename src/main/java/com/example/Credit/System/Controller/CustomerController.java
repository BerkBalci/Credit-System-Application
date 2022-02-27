package com.example.Credit.System.Controller;


import com.example.Credit.System.model.dto.CustomerDTO;
import com.example.Credit.System.model.mapper.CustomerMapper;
import com.example.Credit.System.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;




    @GetMapping(path = "/all")
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping(path = "/get")
    public CustomerDTO getCustomer(@RequestParam Integer id ){
        return customerService.getCustomer(id);
    }

    @GetMapping(path = "/nationalId")
    public CustomerDTO findByNationalId(@RequestParam String nationalId ){
        return customerService.findCustomerByNationalId(nationalId);
    }

    @GetMapping(path = "/application")
    public CustomerDTO Application(@RequestParam String nationalId ){
        return customerService.Application(nationalId);
    }
    
    @PostMapping(path = "/add")
    public boolean addCustomer(@RequestBody CustomerDTO customer){
        return customerService.addCustomer(CustomerMapper.toEntity(customer));
    }


    @PutMapping(value = "/update/{id}")
    public CustomerDTO updateCustomer(@PathVariable Integer id,
                                      @RequestBody CustomerDTO customer){
        return customerService.updateCustomer(id,CustomerMapper.toEntity(customer)) ;
    }

    @DeleteMapping(value = "/delete/id={id}")
    public boolean deleteCustomer(@PathVariable Integer id){

        return customerService.deleteCustomer(id);
    }






    }




