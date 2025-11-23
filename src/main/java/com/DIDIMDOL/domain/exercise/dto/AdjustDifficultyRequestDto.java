package com.DIDIMDOL.domain.exercise.dto;

public class AdjustDifficultyRequestDto {
    private String userId;

    protected AdjustDifficultyRequestDto() {
    }

    public AdjustDifficultyRequestDto(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
