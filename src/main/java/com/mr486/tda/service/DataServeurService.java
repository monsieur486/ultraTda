package com.mr486.tda.service;

import com.mr486.tda.dto.DataServeur;
import com.mr486.tda.dto.ScoreDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataServeurService {

    private final ScoreService scoreService;
    private final ReunionService reunionService;

    public DataServeur getDataServeur() {
        Integer etape = reunionService.reunionActiveStatus();
        List<ScoreDto> scores = scoreService.getScores();
        return
                DataServeur.builder()
                        .etape(etape)
                        .scores(scores)
                        .build();
    }

}
