package com.abden.employeeservice.controller;

import com.abden.employeeservice.model.Employee;
import com.abden.employeeservice.model.EmployeeDTO;
import com.abden.employeeservice.model.EmployeeDepartmentVO;
import com.abden.employeeservice.service.EmployeeService;
import com.abden.employeeservice.service.MicroserviceIntegrationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    private final MicroserviceIntegrationService microserviceIntegrationService;

    public EmployeeController(EmployeeService employeeService, MicroserviceIntegrationService microserviceIntegrationService) {
        this.employeeService = employeeService;
        this.microserviceIntegrationService = microserviceIntegrationService;
    }

    @GetMapping("/")
    public List<EmployeeDepartmentVO> getEmployees() {
       return employeeService.getEmployees();
    }

    @PostMapping("/")
    public Employee saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.saveEmployee(employeeDTO);
    }


}
