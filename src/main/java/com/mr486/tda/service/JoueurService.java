package com.mr486.tda.service;

import com.mr486.tda.entity.Joueur;
import com.mr486.tda.model.Ami;
import com.mr486.tda.repository.JoueurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JoueurService {

    private final JoueurRepository joueurRepository;
    private final AmiService amiService;

    private void save(Integer amiId) {
        joueurRepository.save(new Joueur(amiId));
    }

    public void saveList(List<Integer> amiIds) {
        amiIds.forEach(amiId -> joueurRepository.save(new Joueur(amiId)));
    }

    private List<Joueur> getJoueurs() {
        return joueurRepository.findAll();
    }

    public List<Ami> getAmisInscrits() {
        List<Ami> amis = new ArrayList<>();
        getJoueurs().forEach(joueur -> amis.add(amiService.getAmiById(joueur.getAmiId())));
        return amis.stream()
                .sorted(Comparator.comparing(Ami::getNom))
                .toList();
    }
}
