package com.employee.controller;

import com.employee.pojo.Department;
import com.employee.pojo.Result;
import com.employee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/all")
    public Result<Object> getAllDepartments() {
        List<Department> departments = departmentService.findAllDepartments();
        return Result.success(departments);
    }

    @PostMapping("/add")
    public Result addDepartment(@RequestBody Department department) {
        departmentService.addDepartment(department);
        return Result.success();
    }

    @PutMapping("/update")
    public Result updateDepartment(@RequestBody Department department) {
        departmentService.updateDepartment(department);
        return Result.success();
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody Map<String, String> requestBody){
        String departmentName=requestBody.get("departmentName");
        String jobTitleName=requestBody.get("jobTitleName");
        departmentService.deleteDepartment(departmentName,jobTitleName);
        return Result.success();
    }

    @PostMapping("/findByDepartmentName")
    public Result findByDepartmentName(Department department){

//        String departmentName=requestBody.get("departmentName");
        String departmentName=department.getDepartmentName();
        System.out.println(departmentName);
        return Result.success(departmentService.findDepartmentsByDepartment(departmentName));
    }

}
