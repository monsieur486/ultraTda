package com.mr486.tda.service;

import com.mr486.tda.dto.ResponseDto;
import com.mr486.tda.dto.ScoreDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ResponseDtoService {

    private final ScoreService scoreService;
    private final ReunionService reunionService;

    public ResponseDto getResponseDto() {
        Integer etape = reunionService.reunionActiveStatus();
        log.info("Status : {}", etape);
        List<ScoreDto> scores = scoreService.getScores();
        log.info("Scores : {}", scores);

        return
                ResponseDto.builder()
                        .etape(etape)
                        .scores(scores)
                        .build();
    }

}
