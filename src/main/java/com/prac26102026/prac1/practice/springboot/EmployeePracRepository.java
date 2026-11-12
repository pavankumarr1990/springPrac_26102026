package com.prac26102026.prac1.practice.springboot;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeePracRepository {
    public EmployeePracRepository()
    {

        System.out.println("EmployeeRepository object created "+this.hashCode());
    }
}
