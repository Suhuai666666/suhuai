package com.employee.controller;

import com.employee.pojo.*;
import com.employee.service.*;
import com.employee.utils.ThreadLocalUtil;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/salary")
public class SalaryController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private BenefitsService benefitsService;
//    @Autowired
//    private SalaryLevelService;
    @Autowired
    private SalaryService salaryService;

    @PostMapping("/count")
    public Result countSalary(){
        //清空工资表
        salaryService.deleteAll();
        List<Salary> salaryList=new ArrayList<>();
        List<Employee> employee=employeeService.findAllEmployee();
        List<Department> departments=departmentService.findAllDepartments();
        List<Benefits>benefits=  benefitsService.findAllBenefits();
        SalaryLevel salaryLevel=new SalaryLevel();
        int benefitSum=0;
        //福利总额
        for (int i = 0; i < benefits.size(); i++) {
            benefitSum += benefits.get(i).getBenefitValue();
        }

        int i=employee.size();
        for (int j = 0; j < i; j++) {
            Salary salary=new Salary();
            salary.setEmployeeId(employee.get(j).getEmployeeId());  //设置id
            salary.setEmployeeName(employee.get(j).getEmployeeName());  //设置name
            salary.setBenefitsSalary(benefitSum);//设置奖金
            //岗位工资
            //如果员工的岗位是部门里面的岗位
            for (int k = 0; k < departments.size(); k++) {
                if (employee.get(j).getPost().equals(departments.get(k).getJobTitleName())) {
                    //将岗位薪资赋值给salary
                    salary.setJobTitleSalary(departments.get(k).getJobTitleSalary());
                }
            }
//            System.out.println(employee.get(j).getPost());
//            System.out.println(employee.get(j).getSalaryLevel());
//            System.out.println(employee.get(j).getWordYear());
//            System.out.println(employee.get(j).getEmployeeName());


            //设置工龄工资
            salary.setExperienceSalary(100*employee.get(j).getWorkYear());
            //临时设置的
//            salary.setExperienceSalary(1000);


            //设置工资等级工资
//            salary.setSalaryLevelSalary( salaryLevelService.findSalary(employee.get(i).getSalaryLevel()));
            salary.setSalaryLevelSalary( salaryLevel.levelSalary(employee.get(j).getSalaryLevel()));

            //计算工资总额
            salary.setNetSalary(salary.Count());
            salaryService.add(salary);

            //更新员工表
            employeeService.setEmployeeSalary(salary.getNetSalary(),salary.getEmployeeId());
        }
        return Result.success();
    }

    @GetMapping("/getAll")
    public Result getAll(){
        return Result.success(salaryService.getAll());
    }

    @DeleteMapping("/delete")
    public Result deleteAll(){
        salaryService.deleteAll();
        return Result.success();
    }

    @GetMapping("/findById")
    public  Result findSalaryById(){

        Map<String,Object> map= ThreadLocalUtil.get();
        Integer employeeId=(Integer) map.get("employeeId");
//        System.out.println("employeeId:"+employeeId);

        Salary salary=salaryService.findById(employeeId);
//        System.out.println("salary:"+salary);
//        System.out.println(salary.getEmployeeName());
        return Result.success(salary);
    }

    @GetMapping("/sum")
    public Result sumSalary(){
        return Result.success(salaryService.sumSalary());
    }

}
