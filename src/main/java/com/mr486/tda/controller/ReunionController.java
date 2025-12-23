package com.mr486.tda.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ReunionController {

    @GetMapping("/admin/reunion")
    public String publicView() {
        return "reunion";
    }
}
