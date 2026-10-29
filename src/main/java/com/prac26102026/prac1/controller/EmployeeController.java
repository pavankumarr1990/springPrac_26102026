package com.prac26102026.prac1.controller;

import com.prac26102026.prac1.dto.EmployeeDTO;
import com.prac26102026.prac1.service.impl.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pavan/emp")
@RequiredArgsConstructor
public class EmployeeController {


    @Autowired
    private final EmployeeServiceImpl service;
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    @GetMapping("/{empID}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("empID") int employeeID) {
        return ResponseEntity.ok(service.getByEmpID(employeeID));
    }

}
