package com.DIDIMDOL.domain.exercise.controller;

import com.DIDIMDOL.domain.exercise.dto.AdjustDifficultyRequestDto;
import com.DIDIMDOL.domain.exercise.dto.AdjustDifficultyResponseDto;
import com.DIDIMDOL.domain.exercise.service.ExerciseDifficultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/exercise")
public class ExerciseController {
    private final ExerciseDifficultyService exerciseDifficultyService;

    @PostMapping("/{exerciseId}")
    public ResponseEntity<AdjustDifficultyResponseDto> saveDifficulty(@RequestBody AdjustDifficultyRequestDto requestDto, @PathVariable Long exerciseId) {
        AdjustDifficultyResponseDto responseDto  =
                exerciseDifficultyService.adjustDifficulty(requestDto, exerciseId);
        return ResponseEntity.ok(responseDto);
    }

    @PatchMapping("/{exerciseId}/difficulty/adjust")
    public ResponseEntity<AdjustDifficultyResponseDto> adjustDifficulty(@PathVariable Long exerciseId, @RequestBody AdjustDifficultyRequestDto requestDto) {
        AdjustDifficultyResponseDto responseDto =
                exerciseDifficultyService.adjustDifficulty(requestDto, exerciseId);

        return ResponseEntity.ok(responseDto);
    }
}
