package com.DIDIMDOL.domain.calender.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Builder
public class CalenderRequestDto {
    private Long userId;
    private LocalDate date;
    private String content;

}
