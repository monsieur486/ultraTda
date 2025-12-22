package com.mr486.tda.controller;

import com.mr486.tda.model.Ami;
import com.mr486.tda.service.AmiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AmiController {

    private final AmiService amiService;

    @GetMapping("/api/public/amis")
    public ResponseEntity<List<Ami>> getAmis() {
        return ResponseEntity.ok(amiService.getAmis());
    }

}
