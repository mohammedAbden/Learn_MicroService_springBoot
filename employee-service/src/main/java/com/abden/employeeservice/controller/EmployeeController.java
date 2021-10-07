package com.abden.employeeservice.controller;

import com.abden.employeeservice.model.EmployeeDepartmentVO;
import com.abden.employeeservice.service.EmployeeService;
import com.abden.employeeservice.service.MicroserviceIntegrationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    private final MicroserviceIntegrationService microserviceIntegrationService;

    public EmployeeController(EmployeeService employeeService, MicroserviceIntegrationService microserviceIntegrationService) {
        this.employeeService = employeeService;
        this.microserviceIntegrationService = microserviceIntegrationService;
    }

    @RequestMapping("/dummy")
    public EmployeeDepartmentVO getDummyEmployee() {
        return EmployeeDepartmentVO.builder()
                .employee(employeeService.getDummyEmployee())
                .department(microserviceIntegrationService.getDummyDepartment())
                .build();
    }


}
