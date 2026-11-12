package com.prac26102026.prac1.practice.springboot;

import org.springframework.stereotype.Component;

//@Component
public class EmployeePracCompenent {

    public EmployeePracCompenent() {
        System.out.println("Employee Compenent "+this.getClass().getSimpleName()+this.hashCode());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    Long id;
}
