package com.employee.service;

import com.employee.pojo.Salary;

import java.util.List;

public interface SalaryService {
    public void add(Salary salary);

    void deleteAll();

    Salary findById(Integer employeeId);

    List<Salary> getAll();

    Integer sumSalary();
}
