package com.employee.pojo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

public class Employee {
    //员工编号
    private Integer employeeId;
    //员工姓名
    private String employeeName;
    //员工性别
    private String gender;
    //员工部门
    private String department;

    //员工职位
    private String post;
    //工资等级
    private Integer salaryLevel;

    private Integer workYear;
    //工资
    private Integer salaryAmount;

    public Integer getWorkYear() {
        return workYear;
    }

    public void setWorkYear(Integer wordYear) {
        this.workYear = wordYear;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Integer getSalaryLevel() {
        return salaryLevel;
    }

    public void setSalaryLevel(Integer salaryLevel) {
        this.salaryLevel = salaryLevel;
    }

    public Integer getSalaryAmount() {
        return salaryAmount;
    }

    public void setSalaryAmount(Integer salaryAmount) {
        this.salaryAmount = salaryAmount;
    }
}
