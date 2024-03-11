package com.employee.mapper;

import com.employee.pojo.Benefits;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BenefitsMapper {
    @Select("SELECT * FROM benefits_info")
    List<Benefits> findAllBenefits();

    @Insert("INSERT INTO benefits_info (benefit_name, benefit_value) VALUES (#{benefitName}, #{benefitValue})")
    void addBenefits(Benefits benefits);

    @Delete("DELETE FROM benefits_info WHERE benefit_name = #{benefitName}")
    void deleteBenefits(String benefitName);
}
