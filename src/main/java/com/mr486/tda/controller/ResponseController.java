package com.mr486.tda.controller;

import com.mr486.tda.dto.DataServeur;
import com.mr486.tda.service.DataServeurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class ResponseController {

    private final DataServeurService dataServeurService;

    @GetMapping("/api/public/data")
    public ResponseEntity<DataServeur> getScores() {
        return ResponseEntity.ok(dataServeurService.getDataServeur());
    }
}
