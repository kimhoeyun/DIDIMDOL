package com.DIDIMDOL.domain.exercise.service;

import com.DIDIMDOL.domain.exercise.dto.AdjustDifficultyRequestDto;
import com.DIDIMDOL.domain.exercise.dto.AdjustDifficultyResponseDto;
import com.DIDIMDOL.domain.exercise.entity.Difficulty;
import com.DIDIMDOL.domain.exercise.entity.Exercise;
import com.DIDIMDOL.domain.exercise.entity.UserExerciseResult;
import com.DIDIMDOL.domain.exercise.repository.ExerciseRepository;
import com.DIDIMDOL.domain.exercise.repository.UserExerciseResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseDifficultyService {

    private final ExerciseRepository exerciseRepository;
    private final UserExerciseResultRepository resultRepository;
    private final DifficultyAdjuster difficultyAdjuster;

    @Transactional
    public AdjustDifficultyResponseDto adjustDifficulty(AdjustDifficultyRequestDto requestDto, Long exerciseId) {

        Exercise exercise = exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new IllegalArgumentException("Exercise not found: " + exerciseId));

        List<UserExerciseResult> results =
                resultRepository.findByUserIdAndExerciseOrderByCompletedAtDesc(requestDto.getUserId(), exercise);

        Difficulty newDifficulty =
                difficultyAdjuster.adjust(exercise.getDifficulty(), results);

        exercise.changeDifficulty(newDifficulty);
        exerciseRepository.save(exercise);

        return new AdjustDifficultyResponseDto(newDifficulty);
    }
}