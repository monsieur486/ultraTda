package com.mr486.tda.controller;

import com.mr486.tda.model.ResponseDto;
import com.mr486.tda.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class ResponseController {

    private final ScoreService scoreService;

    @GetMapping("/api/public/data")
    public ResponseEntity<ResponseDto> getScores() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setScores(scoreService.getScores());
        return ResponseEntity.ok(responseDto);
    }
}
