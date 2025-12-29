package com.mr486.tda.service;

import com.mr486.tda.dto.AmiListe;
import com.mr486.tda.model.Ami;
import com.mr486.tda.repository.AmiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AmiService {

    private final AmiRepository amiRepository;

    public List<Ami> getAmis() {
        List<Ami> amis = amiRepository.findAll();
        return amis.stream()
                .sorted(Comparator.comparing(Ami::getIsGuest)
                        .thenComparing(Ami::getNom))
                .toList();
    }

    public Ami getAmiById(Integer id) {
        return amiRepository.findById(id).orElse(null);
    }

    public List<AmiListe> getAmisListe() {
        return getAmis().stream().map(AmiListe::new).toList();
    }

}
