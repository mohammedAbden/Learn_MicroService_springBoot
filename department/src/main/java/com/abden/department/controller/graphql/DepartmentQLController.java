package com.abden.department.controller.graphql;

import com.abden.department.model.Department;
import com.abden.department.model.DepartmentInput;
import com.abden.department.service.DepartmentService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DepartmentQLController {

    private final DepartmentService departmentService;

    public DepartmentQLController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @QueryMapping
    public List<Department> getDepartments() {
        return departmentService.getAllDepartments();
    }

    @MutationMapping
    public Department addDepartment(@Argument DepartmentInput department){
        return departmentService.saveDepartment(Department.builder().name(department.getName()).build());
    }

}