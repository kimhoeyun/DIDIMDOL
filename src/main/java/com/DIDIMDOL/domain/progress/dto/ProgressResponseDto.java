package com.DIDIMDOL.domain.progress.dto;

import com.DIDIMDOL.domain.progress.entity.Progress;
import com.DIDIMDOL.domain.trainingmeta.entity.TrainingType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public final class ProgressResponseDto {
    private Long userId;
    private TrainingType trainingType;
    private Integer bestScore;
    private Integer avgScore;
    private Integer lastScore;
    private int attemptCnt;

    public static ProgressResponseDto fromEntity(Progress progress) {
        return ProgressResponseDto.builder()
                .userId(progress.getUser().getId())
                .trainingType(progress.getTrainingType())
                .bestScore(progress.getBestScore())
                .avgScore(progress.getAvgScore())
                .lastScore(progress.getLastScore())
                .attemptCnt(progress.getAttemptCnt())
                .build();
    }
}
