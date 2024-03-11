package com.employee.service.Impl;

import com.employee.mapper.DepartmentMapper;
import com.employee.pojo.Department;
import com.employee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> findAllDepartments() {
        return departmentMapper.findAllDepartments();
    }

    @Override
    public Department findDepartmentByName( String jobTitleName) {
        return departmentMapper.findDepartmentByName( jobTitleName);
    }

    @Override
    public List<Department> findDepartmentsByDepartment(String departmentName) {
        return departmentMapper.findDepartmentsByDepartment(departmentName);
    }

    @Override
    public void addDepartment(Department department) {
        departmentMapper.addDepartment(department);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentMapper.updateDepartment(department);
    }

    @Override
    public void deleteDepartment(String departmentName, String jobTitleName) {
        departmentMapper.deleteDepartment(departmentName, jobTitleName);
    }
}
