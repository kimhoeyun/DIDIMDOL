package com.DIDIMDOL.domain.calender.service;

import com.DIDIMDOL.domain.calender.dto.CalenderRequestDto;
import com.DIDIMDOL.domain.calender.dto.CalenderResponseDto;
import com.DIDIMDOL.domain.calender.entity.Calender;
import com.DIDIMDOL.domain.calender.repository.CalenderRepository;
import com.DIDIMDOL.domain.user.entity.User;
import com.DIDIMDOL.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalenderService {

    private final CalenderRepository calenderRepository;
    private final UserRepository userRepository;

    @Transactional
    public CalenderResponseDto addCalender(CalenderRequestDto dto){
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다"));;

        Calender calender = calenderRepository.findByUserIdAndDate(dto.getUserId(), dto.getDate())
                .orElseGet(() -> calenderRepository.save(
                        Calender.builder()
                                .user(user)
                                .date(dto.getDate())
                                .content(dto.getContent())
                                .complete(false)
                                .build()
                ) );
        return CalenderResponseDto.fromEntity(calender);
    }

    @Transactional
    public List<CalenderResponseDto> getCalender(Long userId) {
        return calenderRepository.findByUserId(userId)
                .stream()
                .map(CalenderResponseDto::fromEntity)
                .toList();
    }
}