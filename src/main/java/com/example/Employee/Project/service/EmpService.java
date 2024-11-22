package com.example.Employee.Project.service;

import com.example.Employee.Project.dto.RequestDto;
import com.example.Employee.Project.dto.ResponseDto;
import com.example.Employee.Project.entity.Employee;

import java.util.List;

public interface EmpService {

  ResponseDto addEmployee(RequestDto requestDto);
  List<ResponseDto> getAllEmployee();
  ResponseDto updateById(RequestDto requestDto,int id);
  ResponseDto deleteEmployee(int id);
}
