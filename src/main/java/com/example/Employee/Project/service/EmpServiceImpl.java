package com.example.Employee.Project.service;

import com.example.Employee.Project.dto.RequestDto;
import com.example.Employee.Project.dto.ResponseDto;
import com.example.Employee.Project.entity.Employee;
import com.example.Employee.Project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public ResponseDto addEmployee(RequestDto requestDto) {
        Employee employee=mapToEntity(requestDto);
         return mapToResponse(employeeRepository.save(employee));
    }

    @Override
    public List<ResponseDto> getAllEmployee() {
        List<Employee> employees=employeeRepository.findAll();
        List<ResponseDto> responseDtos=new ArrayList<>();
        for(Employee employee:employees)
        {
            ResponseDto responseDto=mapToResponse(employee);
            responseDtos.add(responseDto);
        }
        return responseDtos;
    }

    @Override
    public ResponseDto updateById(RequestDto requestDto, int id)
    {
        Employee employee=employeeRepository.findById(id).orElseThrow(() ->new RuntimeException("Employee id"+id+" is not available"));

        employee.setFName(requestDto.getFName());
        employee.setLName(requestDto.getLName());
        employee.setGender(requestDto.getGender());
        employee.setNotes(requestDto.getNotes());
        employee.setDepartment(requestDto.getDepartment());
        employee.setProfilepic(requestDto.getProfilepic());
        employee.setSalary(requestDto.getSalary());

        employee=employeeRepository.save(employee);
        return mapToResponse(employee);
    }

    @Override
    public ResponseDto deleteEmployee(int id) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with ID " + id + " not found"));
        ResponseDto responseDto = mapToResponse(existingEmployee);

        employeeRepository.delete(existingEmployee);

        return responseDto;
    }

    public Employee mapToEntity(RequestDto requestDto)
    {
        Employee e=new Employee(requestDto);
        return e;
    }

    public ResponseDto mapToResponse(Employee employee)
    {
        ResponseDto responseDto=new ResponseDto();
        responseDto.setFName(employee.getFName());
        responseDto.setLName(employee.getLName());
        responseDto.setDepartment(employee.getDepartment());
        responseDto.setNotes(employee.getNotes());
        responseDto.setGender(employee.getGender());
        responseDto.setProfilepic(employee.getProfilepic());
        responseDto.setSalary(employee.getSalary());
        return responseDto;
    }
}
