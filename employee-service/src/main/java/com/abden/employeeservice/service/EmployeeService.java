package com.abden.employeeservice.service;

import com.abden.employeeservice.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    public Employee getDummyEmployee(){
        return new Employee(1L,"Mohamed",1L);
    }

}
