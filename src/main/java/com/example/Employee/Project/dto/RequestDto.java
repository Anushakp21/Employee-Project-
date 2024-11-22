package com.example.Employee.Project.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {
    private String fName;
    private String lName;
    private int salary;
    private String profilepic;
    private String department;
    private String notes;
    private String gender;
}
