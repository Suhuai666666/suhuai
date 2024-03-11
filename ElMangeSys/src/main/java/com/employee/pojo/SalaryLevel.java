package com.employee.pojo;

import lombok.Data;

//暂时用不到
@Data
public class SalaryLevel {
    //工资等级
    private Integer salaryLevel;
    //等级金额
    private Integer salaryAmount;

    public Integer levelSalary(Integer salaryLevel) {
        Integer salary = 0;
        switch (salaryLevel) {
            case 0:
                salary = 100;
                break;
            case 1:
                salary = 300;
                break;
            case 2:
                salary = 500;
                break;
            case 3:
                salary = 700;
                break;
            case 4:
                salary = 1000;
                break;
            case 5:
                salary = 1200;
                break;
            case 6:
                salary = 1500;
                break;
            case 7:
                salary = 1800;
                break;
            case 8:
                salary = 2000;
                break;
            case 9:
                salary = 2200;
                break;
            case 10:
                salary = 2500;
                break;
        }
        return salary;
    }

}
