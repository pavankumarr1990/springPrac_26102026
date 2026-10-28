package com.prac26102026.prac1.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "department", schema = "employee_management")
public class Department {
    @Id
    private Long departmentId;
    private String departmentName;
    private String location;
    }
