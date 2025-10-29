package com.DIDIMDOL.domain.progress.dto;

import com.DIDIMDOL.domain.trainingmeta.entity.TrainingType;

public record ProgressRequestDto (
        Long userId,
        TrainingType trainingType,
        int score
) {}