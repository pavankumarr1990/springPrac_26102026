package com.prac26102026.prac1.practice.PagenationAndSorting.Service;

import com.prac26102026.prac1.practice.PagenationAndSorting.Entity.EmployeePaginationEntity;
import com.prac26102026.prac1.practice.PagenationAndSorting.REpo.EmployeePaginationRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmployeePaginationService {

    @Autowired
    private EmployeePaginationRepo employeePaginationRepo;

    public List<EmployeePaginationEntity> getAllEmployees() {
        return employeePaginationRepo.findAll();
    }

    public List<EmployeePaginationEntity> getEmployeesByPage(Pageable pageable) {
        return employeePaginationRepo.findAll(pageable).getContent();
    }

    public List<EmployeePaginationEntity> getEmployeesByPageSortSearch(Pageable pageable, String search) {
        if (search == null) {
            return employeePaginationRepo.findAll(pageable).getContent();
        } else {
            return employeePaginationRepo.findByFirstname(search, pageable).getContent();
        }

    }
}

