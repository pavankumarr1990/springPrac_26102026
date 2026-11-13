package com.prac26102026.prac1.practice.TranscationalPrac.entity;

import jakarta.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_wallet", schema = "employee_management")
@Data
public class UserTransPrac1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;
    private double balance;
}
