package com.employee.service;

import com.employee.pojo.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAllDepartments();

    Department findDepartmentByName(String jobTitleName);

    List<Department> findDepartmentsByDepartment(String departmentName);

    void addDepartment(Department department);

    void updateDepartment(Department department);

    void deleteDepartment(String departmentName, String jobTitleName);
}
