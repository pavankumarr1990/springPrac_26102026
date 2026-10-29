package com.prac26102026.prac1.dto;


import lombok.*;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrentUserDTO {

    private Long userId;
    private String userName;
    private String designation;

}