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

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private final EmployeeRepo repo;
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private EmployeeDTO toDTO(EmployeeEntity emp) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmployeeID(emp.getEmployeeId());
        dto.setFirst_name(emp.getFirst_name());
        dto.setJobTitle(emp.getJobTitle());
        dto.setStatus(emp.getStatus());
        return dto;
    }

    @Override
    public EmployeeDTO getByEmpID(int empID) {
        try {
            EmployeeEntity emp = repo.findByEmployeeId(empID).orElseThrow(() -> new RuntimeException("Employee not found"));
            return toDTO(emp);
        } catch (RuntimeException e) {
            throw new InternalServerException(MessageConstant.ERROR_IN_FETCHING_EMPLOYEE);
        }
    }

    @Override
    public EmployeeDTO UpdateStatusToInActiveEmpID(int empNumber) {
        EmployeeEntity emp = repo.findByEmployeeId(empNumber).orElseThrow(() -> new RuntimeException("Employee not found"));
        emp.setStatus("INACTIVE");
        repo.save(emp);
        return toDTO(emp);
    }

    @Override
    public List<EmployeeDTO> getAllEmpList() {
        try {
            return repo.findAll().stream()
                    .map(this::toDTO)
                    .toList();
        } catch (RuntimeException e) {
            throw new InternalServerException(MessageConstant.ERROR_IN_FETCHING_EMPLOYEE);
        }
    }

    @Override
    public List<EmployeeDTO> getAllEmpByStatus(String status) {
       return repo.findAll().stream().filter(emp -> emp.getStatus().equalsIgnoreCase(status))
               .map(this::toDTO)
               .toList();
    }

    @Override
    public List<EmployeeDTO> getEmpByDepartId(String jobTitle) {
        return repo.findAll().stream().filter(emp -> emp.getJobTitle().equalsIgnoreCase(jobTitle))
                .map(this::toDTO)
//                .map(emp -> toDTO(emp))
                .toList();
    }

//    @Override
//    public EmployeeDTO deleteEmpID(int empNumber) {
//        EmployeeEntity emp=repo.findByEmployeeId(empNumber).orElseThrow(() -> new RuntimeException("Employee not found"));
//        repo.delete(emp);
//        return new EmployeeDTO(emp.getEmployeeId(), emp.getFirst_name());
//    }


}
