package com.prac26102026.prac1.service;

import com.prac26102026.prac1.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO getByEmpID(int empNumber);
    EmployeeDTO UpdateStatusToInActiveEmpID(int empNumber);
    List<EmployeeDTO> getAllEmpList();
    List<EmployeeDTO> getAllEmpByStatus(String status);
    List<EmployeeDTO> getEmpByDepartId(String JobTitle);
    EmployeeDTO getEmpByFirstName(String firstName);

///api/employees/filter?minSalary=50000&maxSalary=100000
    List<EmployeeDTO> getEmpSalaryFilter(long minSalary, long maxSalary);

//    /api/employees/highest-paid
    List<EmployeeDTO> getHighestPaidEmp();



}
