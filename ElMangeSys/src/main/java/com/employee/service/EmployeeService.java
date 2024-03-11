package com.employee.service;

import com.employee.pojo.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAllEmployee();
    Employee findByEmployeeName(String EmployeeName);

    Employee findByEmployeeId(Integer id);
    //插入员工信息
    void addEmployee(Employee employee);

    //修改员工信息
    void updateEmployee(Employee employee);

    //删除员工信息
    void deleteEmployee(Integer id);
//    void deleteEmployeeByName(String name);
//设置员工工资
    void setEmployeeSalary(Integer salary,Integer id);

    //统计员工数
    Integer countEmployeeSalary();
}
