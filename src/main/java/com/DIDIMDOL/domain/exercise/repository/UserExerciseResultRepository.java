package com.DIDIMDOL.domain.exercise.repository;

import com.DIDIMDOL.domain.exercise.entity.Exercise;
import com.DIDIMDOL.domain.exercise.entity.UserExerciseResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserExerciseResultRepository extends JpaRepository<UserExerciseResult, Long> {
    List<UserExerciseResult> findByUserIdAndExerciseOrderByCompletedAtDesc(String userId, Exercise exercise);
}
