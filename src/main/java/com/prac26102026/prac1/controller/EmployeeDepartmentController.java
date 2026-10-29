package com.prac26102026.prac1.controller;


import com.prac26102026.prac1.response.EmployeeDeptResponseDTO;
import com.prac26102026.prac1.service.impl.EmployeeDepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departmentEmployee")
public class EmployeeDepartmentController {
    @Autowired
    private EmployeeDepartmentServiceImpl employeeDepartmentService;

    @GetMapping("/departments/{id}/employees")
    public ResponseEntity<List<EmployeeDeptResponseDTO>> getEmployeesByDepartmentId(@PathVariable int id) {
        // Call the service layer to get the employees by department ID
        List<EmployeeDeptResponseDTO> employees = employeeDepartmentService.getEmployeesByDepartmentId(id);

        // Return the response entity with the list of employees
        return ResponseEntity.ok(employees);
    }
}
