package com.employee.service;

import com.employee.pojo.Benefits;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BenefitsService {
    List<Benefits> findAllBenefits();


    void addBenefits(Benefits benefits);


    void deleteBenefits(String benefitName);
}
