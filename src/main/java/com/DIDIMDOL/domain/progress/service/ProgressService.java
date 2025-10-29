package com.DIDIMDOL.domain.progress.service;

import com.DIDIMDOL.domain.progress.dto.ProgressRequestDto;
import com.DIDIMDOL.domain.progress.dto.ProgressResponseDto;
import com.DIDIMDOL.domain.progress.entity.Progress;
import com.DIDIMDOL.domain.progress.repository.ProgressRepository;
import com.DIDIMDOL.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgressService {
    private final ProgressRepository progressRepository;
    private final UserRepository userRepository;

    @Transactional
    public ProgressResponseDto saveResult(ProgressRequestDto requestDto) {
        Progress progress = progressRepository
                .findByUserIdAndTrainingType(requestDto.userId(), requestDto.trainingType())
                .orElseGet(() -> progressRepository.save(
                        Progress.builder()
                                .user(userRepository.getReferenceById(requestDto.userId()))
                                .trainingType(requestDto.trainingType())
                                .attemptCnt(0)
                                .bestScore(0)
                                .avgScore(0)
                                .lastScore(0)
                                .build()
                ));

        progress.updateScores(requestDto.score());
        progressRepository.save(progress);

        return ProgressResponseDto.fromEntity(progress);
    }
}