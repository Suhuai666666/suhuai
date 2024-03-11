package com.employee.mapper;

import com.employee.pojo.Salary;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SalaryMapper {

    @Insert("insert into salary_info(salary_info.employee_id,salary_info.employee_name,salary_info.base_salary,salary_info.job_title_salary,salary_info.salary_Level_salary,salary_info.experience_salary,salary_info.benefits_salary,salary_info.net_salary)" +
            "values(#{employeeId},#{employeeName},#{baseSalary},#{jobTitleSalary},#{salaryLevelSalary},#{experienceSalary},#{benefitsSalary},#{netSalary})")
    void add(Salary salary);

    @Delete("DELETE from salary_info")
    void deleteAll();

    @Select("SELECT * from salary_info where employee_id=#{employeeId}")
    Salary findById(Integer employeeId);

    @Select("SELECT * from salary_info")
    List<Salary> getAll();

    @Select("SELECT sum(net_salary) from salary_info")
    Integer sumSalary();
}
