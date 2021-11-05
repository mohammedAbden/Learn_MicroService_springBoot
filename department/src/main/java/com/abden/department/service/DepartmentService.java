package com.abden.department.service;

import com.abden.department.model.Department;
import com.abden.department.repositories.DepartmentRepository;
import com.abden.department.repositories.spcification.DepartmentSpecifications;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department getDepartmentByName(String name){
        return departmentRepository.findOne(DepartmentSpecifications.departmentName(name)).orElseGet(null);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
