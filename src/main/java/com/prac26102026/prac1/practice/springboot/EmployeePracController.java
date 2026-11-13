//package com.prac26102026.prac1.practice.springboot;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class EmployeePracController {
//
//    //    So at the time of startup, Spring will create an instance of EmployeePracController and EmployeePracCompenent. The constructor of EmployeePracController will be called first, which prints the message "Employee Controller" along with the class name and hash code. Then, the constructor of EmployeePracCompenent will be called, printing "Employee Compenent" with its class name and hash code.
//    public EmployeePracController() {
//        System.out.println("Employee Controller " + this.getClass().getSimpleName() + this.hashCode());
//    }
//
//    @Autowired
//    private EmployeePracCompenent employeePracCompenent;
//
//    @GetMapping("EmployeePrac")
//    public int getEmployeePrac() {
//        return employeePracCompenent.hashCode();
////        return "Employee Controller "+this.getClass().getSimpleName()+this.hashCode();
//    }
//}
