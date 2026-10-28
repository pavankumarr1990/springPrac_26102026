package com.prac26102026.prac1.service.impl;

import com.prac26102026.prac1.constants.MessageConstant;
import com.prac26102026.prac1.dto.EmployeeDTO;
import com.prac26102026.prac1.entity.EmployeeEntity;
import com.prac26102026.prac1.exceptionHandler.InternalServerException;
import com.prac26102026.prac1.repo.EmployeeRepo;
import com.prac26102026.prac1.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private final EmployeeRepo repo;
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);


    @Override
    public EmployeeDTO getByEmpID(int empID) {
        try {
            EmployeeEntity emp = repo.findByEmployeeId(empID).orElseThrow(() -> new RuntimeException("Employee not found"));
            return new EmployeeDTO(
                    emp.getEmployeeId(),
                    emp.getFirst_name());
        } catch (RuntimeException e) {
            throw new InternalServerException(MessageConstant.ERROR_IN_FETCHING_EMPLOYEE);
        }
    }
}
