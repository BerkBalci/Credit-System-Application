package com.example.Credit.System.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String nationalId;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    private Integer monthlyIncome;

    @NotBlank
    private String phoneNumber;

    private Integer creditScore;

    private String creditResult;

    private Integer creditLimit;





}

