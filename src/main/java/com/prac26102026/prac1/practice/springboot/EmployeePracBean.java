package com.prac26102026.prac1.practice.springboot;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeePracBean {

    @Bean("Bean1")
    public EmployeePracCompenent EmployeePracCompenent1() {
        EmployeePracCompenent e1= new EmployeePracCompenent();
        e1.setId(1L);
        return e1;
    }

    @Bean("Bean2")
    public EmployeePracCompenent EmployeePracCompenent2() {
        EmployeePracCompenent e2= new EmployeePracCompenent();
        e2.setId(2L);
        return e2;
    }
}
