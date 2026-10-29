package com.prac26102026.prac1.response;

import lombok.*;

    @Setter
    @Getter
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class EmployeeDeptResponseDTO {
        private int employeeId;
        private String firstName;
        private String lastName;
        private String departmentName;
    }