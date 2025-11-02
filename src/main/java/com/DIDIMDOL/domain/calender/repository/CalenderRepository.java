package com.DIDIMDOL.domain.calender.repository;

import com.DIDIMDOL.domain.calender.entity.Calender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CalenderRepository extends JpaRepository<Calender,Long> {

    Optional<Calender> findByUserIdAndIdAndDate(Long userId,Long id, LocalDate date);
    List<Calender> findByUserId(Long userId);
    List<Calender> findByUserIdAndDade(Long UserId, LocalDate date);
}
