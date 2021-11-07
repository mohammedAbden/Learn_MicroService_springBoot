package com.abden.employeeservice.service;


import com.abden.employeeservice.model.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("DEPARTMENT-SERVICE")
public interface DepartmentIntegrationFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "department/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String name);

    @RequestMapping(method = RequestMethod.GET, value = "department/{id}")
    public Department getDepartmentById(@PathVariable("id")Long departmentId);
}
