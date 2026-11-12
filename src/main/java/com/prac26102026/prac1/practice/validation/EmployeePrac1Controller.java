package com.prac26102026.prac1.practice.validation;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeePrac1Controller {

    @PostMapping("/createEmployee")
    public String createEmployee(EmployeePrac1DTO employeePrac1DTO) {

//        This is biolarplate code for validation. You can use javax.validation annotations in EmployeePrac1DTO class to validate the fields.
//        For example, you can use @NotNull, @Size, @Email, etc. on the fields of EmployeePrac1DTO class to enforce validation rules. Then, you can use @Valid annotation in the controller method parameter to trigger validation.
//        if(employeePrac1DTO.getUsername() == null || employeePrac1DTO.getUsername().isEmpty()) {
//            return "Username is required!";
//        }
        return "Employee created successfully!";
    }
}
