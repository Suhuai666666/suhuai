package com.employee.service.Impl;

import com.employee.mapper.BenefitsMapper;
import com.employee.pojo.Benefits;
import com.employee.service.BenefitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenefitsServiceImpl implements BenefitsService {
    @Autowired
    private BenefitsMapper benefitsMapper;
    @Override
    public List<Benefits> findAllBenefits() {
        return benefitsMapper.findAllBenefits();
    }

    @Override
    public void addBenefits(Benefits benefits) {
        benefitsMapper.addBenefits(benefits);
    }

    @Override
    public void deleteBenefits(String benefitName) {
        benefitsMapper.deleteBenefits(benefitName);
    }
}
