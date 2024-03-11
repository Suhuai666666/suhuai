package com.employee.service.Impl;

import com.employee.mapper.EmployeeMapper;
import com.employee.pojo.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> findAllEmployee() {
        List<Employee> employees= employeeMapper.findAllEmployee();
        return employees;
    }

    @Override
    public Employee findByEmployeeName(String EmployeeName) {
        return employeeMapper.findByEmployeeName(EmployeeName);
    }

    @Override
    public Employee findByEmployeeId(Integer id) {
        return employeeMapper.findByEmployeeId(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        String name=employee.getEmployeeName();
        String gender=employee.getGender();
        String departemt=employee.getDepartment();
        String post= employee.getPost();
        Integer level=employee.getSalaryLevel();
        Integer amount=employee.getSalaryAmount();
        Integer year=employee.getWorkYear();
        employeeMapper.addEmployee(name,gender,departemt,post,level,year,amount);
    }

    @Override
    public void updateEmployee(Employee employee) {
//        Integer id=employeeMapper.findByEmployeeName(employee.getEmployeeName()).getEmployeeId();
//        String departemt=employee.getDepartment();
//        String post= employee.getPost();
//        Integer level=employee.getSalaryLevel();
//        Integer amount=employee.getSalaryAmount();
//        Integer year=employee.getWorkYear();
        employeeMapper.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeMapper.deleteEmployee(id);
    }

//    @Override
//    public void deleteEmployeeByName(String name) {
//        employeeMapper.deleteEmployeeByName(name);
//    }

    @Override
    public void setEmployeeSalary(Integer salary, Integer id) {
        employeeMapper.setEmployeeSalary(salary,id);
    }

    @Override
    public Integer countEmployeeSalary() {
        return employeeMapper.countEmployeeSalary();
    }
}
