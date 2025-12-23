package com.mr486.tda.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PartieController {

    @GetMapping("/admin/partie")
    public String publicView() {
        return "partie";
    }
}
