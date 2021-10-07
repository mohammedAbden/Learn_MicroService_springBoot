package com.abden.department.service;

import com.abden.department.model.Department;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    public Department getDummyDepartment(){
        return new Department(1L,"Account");
    }

}
