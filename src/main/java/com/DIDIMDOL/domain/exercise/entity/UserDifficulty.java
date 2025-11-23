package com.DIDIMDOL.domain.exercise.entity;

import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;

@Getter
public class UserDifficulty {
    private Long id;
    private Exercise exercise;
    private int score;
    private Duration responseTime;
    private boolean success;
    private LocalDateTime completedAt;
}
