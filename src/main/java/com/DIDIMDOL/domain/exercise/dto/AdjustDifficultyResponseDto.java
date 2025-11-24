package com.DIDIMDOL.domain.exercise.dto;

import com.DIDIMDOL.domain.exercise.entity.Difficulty;
import lombok.Getter;

@Getter
public class AdjustDifficultyResponseDto {

    private final Difficulty difficulty;

    public AdjustDifficultyResponseDto(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}
