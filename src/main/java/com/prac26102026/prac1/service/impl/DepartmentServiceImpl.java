package com.prac26102026.prac1.service.impl;

import com.prac26102026.prac1.constants.MessageConstant;
import com.prac26102026.prac1.dto.DepartmentDTO;
import com.prac26102026.prac1.entity.DepartmentEntity;
import com.prac26102026.prac1.repo.DepartmentRepo;
import com.prac26102026.prac1.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private final DepartmentRepo departmentRepo;
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);


    @Override
    public DepartmentDTO addDepartment(DepartmentDTO departmentDTO) {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setDepartmentName(departmentDTO.getDepartmentName());
        departmentEntity.setLocation(departmentDTO.getLocation());
        departmentRepo.save(departmentEntity);
        departmentDTO.setDepartmentId(departmentEntity.getDepartmentId());
        return departmentDTO;
    }

//    @Override
//    public DepartmentDTO addDepartmentExists(DepartmentDTO departmentDTO) {
//        try {

    /// /            // 1. Check if the department name already exists
    /// /            if (departmentRepo.existsByDepartmentName(departmentDTO.getDepartmentName())) {
    /// /                // 2. If it exists, stop everything and throw an exception
    /// /                throw new IllegalArgumentException("Department with name '" + departmentDTO.getDepartmentName() + "' already exists!");
    /// /            }
//
//            boolean isDuplicate = departmentRepo.existsByDepartmentName(departmentDTO.getDepartmentName());
//
//            if (isDuplicate) {
//                throw new IllegalArgumentException("This department name is already taken.");
//            }
//            else {
//                // 3. If it doesn't exist, proceed with the normal insertion
//                DepartmentEntity departmentEntity = new DepartmentEntity();
//                departmentEntity.setDepartmentName(departmentDTO.getDepartmentName());
//                departmentEntity.setLocation(departmentDTO.getLocation());
//
//                DepartmentEntity savedEntity = departmentRepo.save(departmentEntity);
//
//                DepartmentDTO responseDTO = new DepartmentDTO();
//                responseDTO.setDepartmentId(savedEntity.getDepartmentId());
//                responseDTO.setDepartmentName(savedEntity.getDepartmentName());
//                responseDTO.setLocation(savedEntity.getLocation());
//
//                return responseDTO;
//            }
//        } catch (RuntimeException e) {
//            throw new InternalServerException(MessageConstant.ERROR_DEPARTMENT_ALREADY_EXISTS);
//        }
//    }
    @Override
    public DepartmentDTO addDepartmentExists(DepartmentDTO departmentDTO) {
        // 1. Check database for duplicates
        boolean isDuplicate = departmentRepo.existsByDepartmentName(departmentDTO.getDepartmentName());

        if (isDuplicate) {
            LOGGER.error("Department with name '{}' already exists!", departmentDTO.getDepartmentName());
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    MessageConstant.ERROR_DEPARTMENT_ALREADY_EXISTS
            );

        }

        // 3. Proceed with the normal insertion if it doesn't exist
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setDepartmentName(departmentDTO.getDepartmentName());
        departmentEntity.setLocation(departmentDTO.getLocation());

        DepartmentEntity savedEntity = departmentRepo.save(departmentEntity);

        // 4. Map saved entity to response DTO
        DepartmentDTO responseDTO = new DepartmentDTO();
        responseDTO.setDepartmentId(savedEntity.getDepartmentId());
        responseDTO.setDepartmentName(savedEntity.getDepartmentName());
        responseDTO.setLocation(savedEntity.getLocation());

        return responseDTO;
    }

}
