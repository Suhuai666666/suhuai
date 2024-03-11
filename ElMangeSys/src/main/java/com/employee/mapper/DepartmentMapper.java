package com.employee.mapper;

import com.employee.pojo.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentMapper {
   //查询所有
    @Select("SELECT * FROM department_info")
    List<Department> findAllDepartments();

    //根据部门查岗位
   @Select("SELECT * FROM department_info WHERE department_name=#{departmentName}")
    List<Department> findDepartmentsByDepartment(String departmentName);

    @Select("SELECT * FROM department_info WHERE job_Title_Name = #{jobTitleName}")
    Department findDepartmentByName( String jobTitleName);

    @Insert("INSERT INTO department_info (department_Name, job_Title_Name, job_Title_Salary) VALUES (#{departmentName}, #{jobTitleName}, #{jobTitleSalary})")
    void addDepartment(Department department);
    @Update("UPDATE department_info SET job_Title_Salary = #{jobTitleSalary} WHERE department_Name = #{departmentName} AND job_Title_Name = #{jobTitleName}")
    void updateDepartment(Department department);

    @Delete("DELETE FROM department_info WHERE department_Name = #{departmentName} AND job_Title_Name = #{jobTitleName}")
    void deleteDepartment(@Param("departmentName") String departmentName, @Param("jobTitleName") String jobTitleName);
}
