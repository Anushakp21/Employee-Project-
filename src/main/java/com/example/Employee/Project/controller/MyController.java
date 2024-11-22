package com.example.Employee.Project.controller;

import com.example.Employee.Project.dto.RequestDto;
import com.example.Employee.Project.dto.ResponseDto;
import com.example.Employee.Project.entity.Employee;
import com.example.Employee.Project.repository.EmployeeRepository;
import com.example.Employee.Project.service.EmpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    EmpServiceImpl empService;


    @PostMapping("/insert")
    public ResponseDto addEmployees(@RequestBody RequestDto requestDto)
    {
        return empService.addEmployee(requestDto);
    }

    @GetMapping
    public List<ResponseDto> getAllEmployee()
    {
        return empService.getAllEmployee();
    }

    @PutMapping("/{id}")
    public ResponseDto  updateById(@RequestBody RequestDto requestDto,@PathVariable int id)
    {
        return empService.updateById(requestDto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseDto deleteEmployee(@PathVariable int id) {
        return  empService.deleteEmployee(id);
    }
}
