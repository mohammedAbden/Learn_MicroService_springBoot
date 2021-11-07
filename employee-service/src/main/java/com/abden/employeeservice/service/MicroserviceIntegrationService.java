package com.abden.employeeservice.service;

import com.abden.employeeservice.model.Department;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MicroserviceIntegrationService {

    private final RestTemplate restTemplate;
    private final DepartmentIntegrationFeignClient departmentIntegrationFeignClient;

    public MicroserviceIntegrationService(RestTemplate restTemplate, DepartmentIntegrationFeignClient departmentIntegrationFeignClient) {
        this.restTemplate = restTemplate;
        this.departmentIntegrationFeignClient = departmentIntegrationFeignClient;
    }

    public Department getDepartmentByName(String departmentName) {
//        return restTemplate.getForEntity("http://DEPARTMENT-SERVICE/department/name/"+departmentName, Department.class).getBody();
       return departmentIntegrationFeignClient.getDepartmentByName(departmentName);
    }

    public Department getDepartmentById(Long departmentId) {
//        return restTemplate.getForEntity("http://DEPARTMENT-SERVICE/department/"+departmentId, Department.class).getBody();
        return departmentIntegrationFeignClient.getDepartmentById(departmentId);
    }
}
