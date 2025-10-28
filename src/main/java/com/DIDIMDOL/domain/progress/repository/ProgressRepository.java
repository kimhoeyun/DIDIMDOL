package com.DIDIMDOL.domain.progress.repository;

import com.DIDIMDOL.domain.progress.entity.Progress;
import com.DIDIMDOL.domain.trainingmeta.entity.TrainingType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProgressRepository extends JpaRepository<Progress, Long> {

    // (userId, trainingType) 조합으로 Progress 조회
    Optional<Progress> findByUserIdAndTrainingType(Long userId, TrainingType trainingType);
}
