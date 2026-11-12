package com.prac26102026.prac1.practice.validation;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePrac1DTO {

    private String name;
    private String username;
    private String password;
    private int age;
    private Double salary;
    private Double accountBalance;
    private String email;
    private String corportateEmail;
    private LocalDate lol;
    private LocalDate expiryDate;
    private List<String> hobbies;


}
