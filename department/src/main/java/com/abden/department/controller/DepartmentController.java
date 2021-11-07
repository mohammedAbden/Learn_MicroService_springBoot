package com.abden.department.controller;

import com.abden.department.model.Department;
import com.abden.department.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{name}")
    public Department getDepartmentByName(@PathVariable String name){
        return departmentService.getDepartmentByName(name);
    }

    @GetMapping("/")
    public List<Department> getDepartments(){
        return departmentService.getAllDepartments();
    }

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }
}
