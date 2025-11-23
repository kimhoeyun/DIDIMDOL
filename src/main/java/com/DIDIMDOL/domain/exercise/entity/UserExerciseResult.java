package com.DIDIMDOL.domain.exercise.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
public class UserExerciseResult {

    @Id @GeneratedValue
    private Long id;

    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Exercise exercise;

    @Getter
    private int score;

    @Getter
    private LocalDateTime completedAt;

    protected UserExerciseResult() {}

    public UserExerciseResult(String userId, Exercise exercise, int score, LocalDateTime completedAt) {
        this.userId = userId;
        this.exercise = exercise;
        this.score = score;
        this.completedAt = completedAt;
    }

}
