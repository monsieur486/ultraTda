package com.mr486.tda.service;

import com.mr486.tda.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResponseDtoService {

    private final ScoreService scoreService;

    public ResponseDto getResponseDto() {
        return ResponseDto.builder().scores(scoreService.getScores()).build();
    }

}
