package com.prac26102026.prac1.service;

import com.prac26102026.prac1.dto.DepartmentDTO;

public interface DepartmentService {
    DepartmentDTO addDepartment(DepartmentDTO departmentDTO) ;

    DepartmentDTO addDepartmentExists(DepartmentDTO departmentDTO1);

    DepartmentDTO updateDepartment(DepartmentDTO departmentDTO);

    DepartmentDTO deleteDepartment(DepartmentDTO departmentDTO);

    DepartmentDTO deleteDepartment1(String departmentName);
}
