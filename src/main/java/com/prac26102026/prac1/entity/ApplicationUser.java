package com.prac26102026.prac1.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "application_user", schema = "employee_management")
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name", unique = true)
    private String userName;

    // Supports databases that still have the old username column.
    @Column(name = "username")
    private String username;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "designation_id")
//    private Designation designation;

//@ManyToOne(fetch = FetchType.LAZY)
//@JoinColumn(name = "designation_id")
//private Designation designation;

    @Column(name = "designation_id")
    private Long designationId;

    @Column(name = "active", nullable = false)
    private Boolean active = true;



}