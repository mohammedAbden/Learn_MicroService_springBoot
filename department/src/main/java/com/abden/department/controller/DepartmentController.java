package com.abden.department.controller;

import com.abden.department.model.Department;
import com.abden.department.service.DepartmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping("/dummy")
    public Department getDummyDepartment() {
        return departmentService.getDummyDepartment();
    }


}
