package com.mr486.tda.service;

import com.mr486.tda.dto.ScoreDto;
import com.mr486.tda.model.Score;
import com.mr486.tda.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScoreService {

    private final ScoreRepository scoreRepository;

    public List<ScoreDto> getScores() {
        List<Score> scores = scoreRepository.findAll();


        return scores.stream()
                .sorted(Comparator.comparingInt(Score::getScore)
                        .thenComparing(Score::getNom))
                .map(score -> ScoreDto.builder()
                        .nom(score.getNom())
                        .score(score.getScore())
                        .imageUrl(score.getImageUrl())
                        .color(getColor(score.getScore()))
                        .build())
                .toList();
    }

    private String getColor(int score) {
        if (score > 0) {
            return "#0000FF";
        } else if (score < 0) {
            return "#FF0000";
        } else {
            return "#000000";
        }
    }
}
