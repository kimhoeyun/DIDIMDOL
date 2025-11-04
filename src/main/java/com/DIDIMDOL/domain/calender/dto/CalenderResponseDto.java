package com.DIDIMDOL.domain.calender.dto;

import com.DIDIMDOL.domain.calender.entity.Calender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Builder
public class CalenderResponseDto {
     private Long userId;
     private Long id;
     private LocalDate date;
     private String content;
     private boolean complete;

     public static CalenderResponseDto fromEntity(Calender calender){
         return CalenderResponseDto.builder()
                 .userId(calender.getUser().getId())
                 .id(calender.getId())
                 .date(calender.getDate())
                 .content(calender.getContent())
                 .complete(calender.isComplete())
                 .build();
     }
}
