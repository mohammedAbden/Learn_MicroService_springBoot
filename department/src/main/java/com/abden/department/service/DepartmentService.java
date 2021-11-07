package com.abden.department.service;

import com.abden.department.model.Department;
import com.abden.department.repositories.DepartmentRepository;
import com.abden.department.repositories.spcification.DepartmentSpecifications;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
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

    public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }
}
