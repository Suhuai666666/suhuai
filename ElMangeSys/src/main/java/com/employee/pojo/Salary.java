package com.employee.pojo;

import lombok.Data;

@Data
public class Salary {
    //员工id
    private Integer employeeId;
    //员工姓名
    private String employeeName;
    //基础工资
    private Integer baseSalary=3000;
    //岗位工资
    private Integer jobTitleSalary;
    //工资等级工资
    private Integer salaryLevelSalary;
    //工龄工资
    private Integer experienceSalary;
    //福利
    private Integer benefitsSalary;
    //工资总额
    private Integer netSalary;

    public Integer Count(){
        return this.baseSalary+this.jobTitleSalary+this.salaryLevelSalary+this.experienceSalary+this.benefitsSalary;
    }
}


//工资总额=基础工资+岗位工资+等级工资+工龄工资（工龄*100）+福利
//福利：增加福利  删除福利