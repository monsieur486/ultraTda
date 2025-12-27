package com.mr486.tda.controller;

import com.mr486.tda.service.DataServeurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PublicController {

    private final DataServeurService dataServeurService;

    @GetMapping("/")
    public String publicView(Model model) {
        model.addAttribute("etape", dataServeurService.getDataServeur().getEtape());
        return "home";
    }
}
