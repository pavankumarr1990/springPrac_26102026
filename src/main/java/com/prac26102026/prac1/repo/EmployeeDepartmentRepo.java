package com.prac26102026.prac1.repo;

import com.prac26102026.prac1.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDepartmentRepo extends JpaRepository<DepartmentEntity, Integer> {
    @Query(value = "SELECT e.employee_id, e.first_name, e.last_name, d.department_name " +
            "FROM employee e " +
            "INNER JOIN department d ON e.department_id = d.department_id " +
            "WHERE d.department_id = :deptId", nativeQuery = true)
    List<Object[]> findEmployeeByDepID(@Param("deptId") int departmentId);
}
