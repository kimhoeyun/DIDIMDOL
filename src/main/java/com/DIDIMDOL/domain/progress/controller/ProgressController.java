package com.DIDIMDOL.domain.progress.controller;

import com.DIDIMDOL.domain.progress.dto.ProgressRequestDto;
import com.DIDIMDOL.domain.progress.dto.ProgressResponseDto;
import com.DIDIMDOL.domain.progress.service.ProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/progress")
public class ProgressController {
    private final ProgressService progressService;

    @PostMapping
    public ResponseEntity<ProgressResponseDto> returnResult(@RequestBody ProgressRequestDto requestDto) {
        ProgressResponseDto responseDto =
                progressService.saveResult(requestDto);
        return ResponseEntity.ok(responseDto);
    }
}
