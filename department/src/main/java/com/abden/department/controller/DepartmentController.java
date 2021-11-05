package com.abden.department.controller;

import com.abden.department.model.Department;
import com.abden.department.service.DepartmentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping("/{name}")
    public Department getDummyDepartment(@PathVariable String name){
        return departmentService.getDepartmentByName(name);
    }


}
