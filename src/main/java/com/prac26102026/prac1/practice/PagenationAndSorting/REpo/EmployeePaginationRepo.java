package com.prac26102026.prac1.practice.PagenationAndSorting.REpo;

import com.prac26102026.prac1.practice.PagenationAndSorting.Entity.EmployeePaginationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePaginationRepo extends JpaRepository<EmployeePaginationEntity, Long> {

    Page<EmployeePaginationEntity> findByFirstname(String firstname, Pageable pageable);
}
