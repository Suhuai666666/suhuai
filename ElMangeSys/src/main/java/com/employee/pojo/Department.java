package com.employee.pojo;


import lombok.Data;

@Data
public class Department {
    //部门名称
    private String departmentName;
    //工作名称
    private String jobTitleName;
    //工作工资
    private Integer jobTitleSalary;
}
