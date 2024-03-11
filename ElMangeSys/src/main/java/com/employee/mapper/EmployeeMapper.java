package com.employee.mapper;

import com.employee.pojo.Employee;
import com.employee.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    //查看全部员工信息
    @Select("select  * from  Employee_info")
    List<Employee> findAllEmployee();


    //查询单个员工信息
    @Select("select * from  Employee_info where Employee_Name=#{EmployeeName}")
    Employee findByEmployeeName(String EmployeeName);

    @Select("select * from  Employee_info where employee_id=#{EmployeeId}")
    Employee findByEmployeeId(Integer EmployeeId);
    //插入员工信息
    @Insert("insert into Employee_info(employee_name,gender,department,post,salary_level,work_year,salary_amount)" +
            " values(#{name},#{gender},#{department},#{post},#{level},#{year},#{amount})")
    void addEmployee(String name,String gender,String department,String post,Integer level,Integer year,Integer amount);

    //修改员工信息
    @Update("update Employee_info set employee_info.employee_name=#{employeeName},employee_info.gender=#{gender},department=#{department},post=#{post},salary_level=#{salaryLevel},salary_amount=#{salaryAmount},work_year=#{workYear} where employee_id=#{employeeId}")
    void updateEmployee(Employee employee);

    //删除员工信息根据ID
    @Delete("delete from Employee_info where employee_id=#{id}")
    void deleteEmployee(Integer id);


    //删除员工信息根据名称
//    @Delete("delete from Employee_info where employee_name=#{name}")
//    void deleteEmployeeByName(String name);
    @Update("update  employee_info set salary_amount=#{salary} where employee_id=#{id}")
    void setEmployeeSalary(Integer salary,Integer id);

    //汇总员工总数
    @Select("select count(*) from employee_info")
    Integer countEmployeeSalary();
}


