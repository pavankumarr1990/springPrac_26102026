package com.prac26102026.prac1.repo;

import com.prac26102026.prac1.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer> {
    Optional<EmployeeEntity> findByEmployeeId(Integer employeeId);
}
