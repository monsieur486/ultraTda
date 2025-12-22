package com.mr486.tda.controller;

import com.mr486.tda.service.ServerStateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PublicController {

    @GetMapping("/")
    public String publicView() {
        return "home";
    }
}
