package com.abden.department.repositories.spcification;

import com.abden.department.model.Department;
import com.abden.department.model.Department_;
import org.springframework.data.jpa.domain.Specification;

public class DepartmentSpecifications {

    public static Specification<Department> departmentName(String name) {
       return (root,cq,cb) -> cb.equal(root.get(Department_.NAME),name);
    }
}
