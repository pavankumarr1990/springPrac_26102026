package com.prac26102026.prac1.controller;

import com.prac26102026.prac1.dto.DepartmentDTO;
import com.prac26102026.prac1.service.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/department")
public class DepartmentController {


    @Autowired
    DepartmentServiceImpl service;
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping("/addDepartment")
    public DepartmentDTO addDepartment(@RequestBody DepartmentDTO departmentDTO) {
//        return service.addDepartment(service.addDepartment(departmentDTO));
        return service.addDepartment(departmentDTO);
    }

    @PostMapping("/addDepartmentExists")
    public ResponseEntity<DepartmentDTO> addDepartmentExists(@RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO savedDepartment = service.addDepartmentExists(departmentDTO);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

}
