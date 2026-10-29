package com.prac26102026.prac1.service.impl;


import com.prac26102026.prac1.repo.EmployeeDepartmentRepo;
import com.prac26102026.prac1.response.EmployeeDeptResponseDTO;
import com.prac26102026.prac1.service.EmployeeDepartmentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeDepartmentServiceImpl implements EmployeeDepartmentService {
    @Autowired
    private final EmployeeDepartmentRepo employeeDepartmentRepo;
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDepartmentServiceImpl.class);


    @Override
    public List<EmployeeDeptResponseDTO> getEmployeesByDepartmentId(int departmentId) {
        // 1. Fetch the raw query data from your repository
        List<Object[]> rawResults = employeeDepartmentRepo.findEmployeeByDepID(departmentId);

        // 2. Initialize the result list
        List<EmployeeDeptResponseDTO> employeeList = new ArrayList<>();

        // 3. Loop through the rows and unpack data safely based on SELECT index
        for (Object[] row : rawResults) {
            // e.employee_id is index 0
            int empId = ((Number) row[0]).intValue();

            // e.first_name is index 1
            String firstName = (String) row[1];

            // e.last_name is index 2
            String lastName = (String) row[2];

            // d.department_name is index 3
            String deptName = (String) row[3];

            // 4. Create your clean response object and add it to your list
            EmployeeDeptResponseDTO dto = new EmployeeDeptResponseDTO(empId, firstName, lastName, deptName);
            employeeList.add(dto);
        }

        return employeeList;
    }
}
