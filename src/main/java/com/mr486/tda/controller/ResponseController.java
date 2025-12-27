package com.mr486.tda.controller;

import com.mr486.tda.dto.ResponseDto;
import com.mr486.tda.service.ResponseDtoService;
import com.mr486.tda.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class ResponseController {

    private final ResponseDtoService responseDtoService;

    @GetMapping("/api/public/data")
    public ResponseEntity<ResponseDto> getScores() {
        return ResponseEntity.ok(responseDtoService.getResponseDto());
    }
}
