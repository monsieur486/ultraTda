package com.mr486.tda.controller;

import com.mr486.tda.service.AmiService;
import com.mr486.tda.service.DataServeurService;
import com.mr486.tda.service.JoueurService;
import com.mr486.tda.service.ReunionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReunionController {

    private final DataServeurService dataServeurService;
    private final AmiService amiService;
    private final JoueurService joueurService;
    private final ReunionService reunionService;

    @GetMapping("/admin/reunion")
    public String publicView(Model model) {
        model.addAttribute("etape", dataServeurService.getDataServeur().getEtape());
        model.addAttribute("amis", amiService.getAmisListe());
        return "reunion";
    }

    @PostMapping("/admin/reunion/creation")
    public String creerReunion(@RequestParam(name = "amiIds", required = false) List<Integer> amiIds,
                               RedirectAttributes redirectAttributes) {

        int count = (amiIds == null) ? 0 : amiIds.size();
        if (count < 4 || count > 6) {
            redirectAttributes.addFlashAttribute("creationError",
                    "Veuillez sélectionner entre 4 et 6 amis (actuellement: " + count + ").");
            return "redirect:/admin/reunion";
        }

        joueurService.saveList(amiIds);
        reunionService.setReunionStatus(2);

        redirectAttributes.addFlashAttribute("creationSuccess",
                "Sélection validée (" + count + " amis).");
        return "redirect:/admin/reunion";
    }
}
