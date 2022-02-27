package com.example.Credit.System.model.dto;


import lombok.Data;



@Data
public class CustomerDTO {

    private String nationalId;
    private String name;
    private String surname;
    private Integer monthlyIncome;
    private String phoneNumber;
    private Integer creditScore;
    private String creditResult;
    private Integer creditLimit;

}
