package com.employee.controller;

import com.employee.dto.DeleteRequestDTO;
import com.employee.pojo.Benefits;
import com.employee.pojo.Result;
import com.employee.service.BenefitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//福利相关接口
@RestController
@RequestMapping("/benefits")
public class BenefitsController {
    @Autowired
    private BenefitsService benefitsService;

    @PostMapping("/add")
    public Result add(@RequestBody Benefits benefits){
        benefitsService.addBenefits(benefits);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<Benefits>> list(){
//        System.out.println("ok");
//        System.out.println(benefitsService.findAllBenefits());
        return Result.success(benefitsService.findAllBenefits());
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteRequestDTO requestDTO) {
        String benefitName = requestDTO.getBenefitName();
//        System.out.println(benefitName);
        benefitsService.deleteBenefits(benefitName);
        return Result.success();
    }
}
