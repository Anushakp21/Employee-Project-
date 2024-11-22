package com.example.Employee.Project.entity;

import com.example.Employee.Project.dto.RequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    private int emp_id;
    private String fName;
    private String lName;
    private int salary;
    private String profilepic;
    private String department;
    private LocalDate doj;
    private String notes;
    private String gender;

    public Employee(RequestDto requestDto)
    {
        this.fName= requestDto.getFName();
        this.lName=requestDto.getLName();
        this.department=requestDto.getDepartment();
        this.salary=requestDto.getSalary();
        this.gender= requestDto.getGender();
        this.notes= requestDto.getNotes();
        this.profilepic=requestDto.getProfilepic();
        this.doj=LocalDate.now();
    }
}
