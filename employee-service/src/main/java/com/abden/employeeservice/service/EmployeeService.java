package com.abden.employeeservice.service;

import com.abden.employeeservice.model.Department;
import com.abden.employeeservice.model.Employee;
import com.abden.employeeservice.model.EmployeeDTO;
import com.abden.employeeservice.model.EmployeeDepartmentVO;
import com.abden.employeeservice.repo.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final MicroserviceIntegrationService microserviceIntegrationService;

    public EmployeeService(EmployeeRepository employeeRepository, MicroserviceIntegrationService microserviceIntegrationService) {
        this.employeeRepository = employeeRepository;
        this.microserviceIntegrationService = microserviceIntegrationService;
    }

    public List<EmployeeDepartmentVO> getEmployees() {
        return employeeRepository.findAll().stream().map(employee -> {

            return EmployeeDepartmentVO.builder()
                    .employee(employee)
                    .department(microserviceIntegrationService.getDepartmentById(employee.getDepartmentId())
                    ).build();

        }).collect(Collectors.toList());
    }

    public Employee saveEmployee(EmployeeDTO employeeDTO) {
        Department dep = microserviceIntegrationService.getDepartmentByName(employeeDTO.getDepartmentName());
        return employeeRepository.save(Employee.builder()
                .name(employeeDTO.getName())
                .departmentId(dep.getId())
                .build());
    }
}
