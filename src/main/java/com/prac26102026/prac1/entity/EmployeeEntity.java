package com.prac26102026.prac1.entity;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employee", schema = "employee_management")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", unique = true, nullable = false)
    private Integer employeeId;
    private String first_name;

}