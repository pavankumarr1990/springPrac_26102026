package com.prac26102026.prac1.repo;

import com.prac26102026.prac1.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<DepartmentEntity, Integer> {
    DepartmentEntity save(DepartmentEntity departmentEntity);
    boolean existsByDepartmentName(String departmentName);
}
