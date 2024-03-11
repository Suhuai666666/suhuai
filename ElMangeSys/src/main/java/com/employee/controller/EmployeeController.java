package com.employee.controller;

import com.employee.pojo.Employee;
import com.employee.pojo.Result;
import com.employee.service.EmployeeService;
import com.employee.utils.ThreadLocalUtil;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/employee")
@Validated//值校验
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    //添加员工
    @PostMapping("/addEmployee")
    public Result add(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return Result.success();
    }

    //查看全部员工
    @GetMapping("/findAll")
    public Result findAdd() {
        List<Employee> employees = employeeService.findAllEmployee();
        System.out.println(employees);
        return Result.success(employees);
    }

    //根据名称查找
    @GetMapping("/findByName")
    public Result findByName(@RequestParam String employeeName){
         Employee employee=employeeService.findByEmployeeName(employeeName);
         return Result.success(employee);
    }

    //根据id查找
    @GetMapping("/findById")
    public Result findById(){
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer employeeId=(Integer) map.get("employeeId");
//        System.out.println("www:"+employeeId);
        Employee employee=employeeService.findByEmployeeId(employeeId);
        return Result.success(employee);
    }
    //修改员工信息
    @PutMapping("/update")
    public Result update(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
        return Result.success();
    }

    //删除员工信息
   @DeleteMapping("/delete")
    public Result delete(@RequestBody Map<String, String> requestBody){
//       System.out.println(requestBody);
       String employeeName=requestBody.get("employeeName");
        Employee employee=employeeService.findByEmployeeName(employeeName);
        employeeService.deleteEmployee(employee.getEmployeeId());
        return Result.success();
    }

    //统计员工数
    @GetMapping("/sum")
    public Result sum(){
//        System.out.println(employeeService.countEmployeeSalary());
        return Result.success(employeeService.countEmployeeSalary());
    }
}
