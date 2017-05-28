package com.taxsys.dto;

import com.taxsys.model.Outcome;

public class OutcomeDto {
    // 用户是否创建成功
    private boolean isSuccess;

    // 错误信息
    private String message;

    // 用户信息
    private Outcome outcome;

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getMessage() {
        return message;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public OutcomeDto(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public OutcomeDto(boolean isSuccess, Outcome outcome) {
        this.isSuccess = isSuccess;
        this.outcome = outcome;
    }

}
