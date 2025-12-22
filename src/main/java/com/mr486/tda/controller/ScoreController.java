package com.mr486.tda.controller;

import com.mr486.tda.model.ScoreDto;
import com.mr486.tda.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScoreController {

    private final ScoreService scoreService;

    @GetMapping("/api/public/scores")
    public ResponseEntity<List<ScoreDto>> getScores() {
        return ResponseEntity.ok(scoreService.getScores());
    }
}
