package com.DIDIMDOL.domain.calender.controller;

import com.DIDIMDOL.domain.calender.dto.CalenderRequestDto;
import com.DIDIMDOL.domain.calender.dto.CalenderResponseDto;
import com.DIDIMDOL.domain.calender.entity.Calender;
import com.DIDIMDOL.domain.calender.service.CalenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/calender")
public class CalenderController {
    private final CalenderService calenderService;

    @PostMapping
    public ResponseEntity<CalenderResponseDto> addCalender(@RequestBody CalenderRequestDto dto){
        CalenderResponseDto calenderResponseDto = calenderService.addCalender(dto.getUserId(), dto);

        return ResponseEntity.ok(calenderResponseDto);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<CalenderResponseDto>> getAllCalenders(@PathVariable Long userId) {
        return ResponseEntity.ok(calenderService.getCalender(userId));
    }

}
