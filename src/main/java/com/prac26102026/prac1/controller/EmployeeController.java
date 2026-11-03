package com.prac26102026.prac1.controller;

import com.prac26102026.prac1.dto.EmployeeDTO;
import com.prac26102026.prac1.service.impl.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/emp")
@RequiredArgsConstructor
public class EmployeeController {


    @Autowired
    private final EmployeeServiceImpl service;
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping("/{empID}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("empID") int employeeID) {
        return ResponseEntity.ok(service.getByEmpID(employeeID));
    }

    @PatchMapping ("/update/{empID}")
    public ResponseEntity<EmployeeDTO> updateEmployeeStatus(@PathVariable("empID") int employeeID) {
        return ResponseEntity.ok(service.UpdateStatusToInActiveEmpID(employeeID));
    }

    @GetMapping("/EmpByStatus/{status}")
    public ResponseEntity<List<EmployeeDTO>> getAllEmpByStatus(@PathVariable("status") String status) {
        return ResponseEntity.ok(service.getAllEmpByStatus(status));
    }


    @GetMapping("/EmpByJobTitle/{jobTitle}")
    public ResponseEntity<List<EmployeeDTO>> getEmpByDepartId(@PathVariable String jobTitle) {
        return ResponseEntity.ok(service.getEmpByDepartId(jobTitle));
    }

///api/employees/search?name=Rahul
    @GetMapping("/employees/search")
    public ResponseEntity<List<EmployeeDTO>> getEmpByName(@RequestParam String pavanName) {
        return ResponseEntity.ok(Collections.singletonList(service.getEmpByFirstName(pavanName)));
    }

    /// ///api/employees/filter?minSalary=50000&maxSalary=100000
    @GetMapping("/employees/filter")
    public ResponseEntity<List<List<EmployeeDTO>>> getEmpByName(@RequestParam long minSalary, @RequestParam long maxSalary) {
        return ResponseEntity.ok(Collections.singletonList(service.getEmpSalaryFilter(minSalary, maxSalary)));
    }

}
