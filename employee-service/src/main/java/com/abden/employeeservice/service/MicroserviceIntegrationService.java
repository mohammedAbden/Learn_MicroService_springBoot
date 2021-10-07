package com.abden.employeeservice.service;

import com.abden.employeeservice.model.Department;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MicroserviceIntegrationService {

    private final RestTemplate restTemplate;

    public MicroserviceIntegrationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Department getDummyDepartment() {
        return restTemplate.getForEntity("http://DEPARTMENT-SERVICE/department/dummy", Department.class).getBody();
    }
}
