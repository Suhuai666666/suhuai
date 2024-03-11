package com.employee.dto;

public class DeleteRequestDTO {
    private String benefitName;

    public String getBenefitName() {
        return benefitName;
    }

    public void setBenefitName(String benefitName) {
        this.benefitName = benefitName;
    }
// Getter and Setter methods

    // 必须要有无参构造函数
    public DeleteRequestDTO() {
    }

    public DeleteRequestDTO(String benefitName) {
        this.benefitName = benefitName;
    }
}
