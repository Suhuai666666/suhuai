package com.employee.service.Impl;

import com.employee.mapper.SalaryMapper;
import com.employee.pojo.Salary;
import com.employee.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryMapper salaryMapper;
    @Override
    public void add(Salary salary) {
        salaryMapper.add(salary);
    }

    @Override
    public void deleteAll() {
        salaryMapper.deleteAll();
    }

    @Override
    public Salary findById(Integer employeeId) {
       return salaryMapper.findById(employeeId);
    }

    @Override
    public List<Salary> getAll() {

        return  salaryMapper.getAll();
    }

    @Override
    public Integer sumSalary() {
        return salaryMapper.sumSalary();
    }
}
