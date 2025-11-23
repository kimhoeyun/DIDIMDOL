package com.DIDIMDOL.domain.exercise.service;

import com.DIDIMDOL.domain.exercise.entity.Difficulty;
import com.DIDIMDOL.domain.exercise.entity.UserExerciseResult;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

import static com.DIDIMDOL.domain.exercise.entity.Difficulty.*;

@Component
public class DifficultyAdjuster {

    private static final int WINDOW_SIZE = 5;

    public Difficulty adjust(Difficulty current, List<UserExerciseResult> adjusted) {

        // 5회 미만 → 기본 난이도 LEVEL_1로 설정
        if (adjusted.size() < WINDOW_SIZE) {
            return LEVEL_1;
        }

        // 최신 5개만 사용
        List<UserExerciseResult> recent = adjusted.stream()
                .sorted(Comparator.comparing(UserExerciseResult::getCompletedAt).reversed())
                .limit(WINDOW_SIZE)
                .toList();

        double avgScore = calculateAverageScore(adjusted);

        boolean allAbove = recent.stream().allMatch(r -> r.getScore() >= avgScore);
        boolean allBelow = recent.stream().allMatch(r -> r.getScore() < avgScore);

        if (allAbove) return next(current);
        if (allBelow) return previous(current);

        return current;
    }

    private double calculateAverageScore(List<UserExerciseResult> adjusted) {
        return adjusted.stream()
                .mapToInt(UserExerciseResult::getScore)
                .average()
                .orElse(Double.NaN);
    }

    private Difficulty next(Difficulty current) {
        return switch (current) {
            case LEVEL_1 -> LEVEL_2;
            case LEVEL_2 -> LEVEL_3;
            default -> LEVEL_3;
        };
    }

    private Difficulty previous(Difficulty current) {
        return switch (current) {
            case LEVEL_3 -> LEVEL_2;
            case LEVEL_2 -> LEVEL_1;
            default -> LEVEL_1;
        };
    }
}