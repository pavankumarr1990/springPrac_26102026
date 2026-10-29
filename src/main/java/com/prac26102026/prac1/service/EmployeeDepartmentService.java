package com.prac26102026.prac1.service;

import com.prac26102026.prac1.dto.DepartmentDTO;
import com.prac26102026.prac1.response.EmployeeDeptResponseDTO;

import java.util.List;

public interface EmployeeDepartmentService {

    List<EmployeeDeptResponseDTO> getEmployeesByDepartmentId(int departmentId);
}
