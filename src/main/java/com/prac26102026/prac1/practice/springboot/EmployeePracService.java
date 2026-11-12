package com.prac26102026.prac1.practice.springboot;


import org.springframework.stereotype.Service;

@Service
public class EmployeePracService {
    public EmployeePracService()
    {
        System.out.println("EmployeeService object created "+this.hashCode());
    }

}
