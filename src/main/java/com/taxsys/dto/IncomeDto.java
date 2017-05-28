package com.taxsys.dto;

import com.taxsys.model.Income;

public class IncomeDto {
    // 用户是否创建成功
    private boolean isSuccess;

    // 错误信息
    private String message;

    // 用户信息
    private Income income;

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getMessage() {
        return message;
    }

    public Income getIncome() {
        return income;
    }

    public IncomeDto(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public IncomeDto(boolean isSuccess, Income income) {
        this.isSuccess = isSuccess;
        this.income = income;
    }

}
