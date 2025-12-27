package com.mr486.tda.service;

import com.mr486.tda.entity.Reunion;
import com.mr486.tda.repository.ReunionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReunionService {

    private final ReunionRepository reunionRepository;

    public Reunion getReunionActive() {
        return reunionRepository.findFirstByEstActiveTrue()
                .orElseGet(() -> {
                    Reunion nouvelle = new Reunion();
                    nouvelle.setEstActive(true);
                    nouvelle.setStatus(1);
                    return reunionRepository.save(nouvelle);
                });
    }

    public void setReunionStatus(Integer status) {
        if (status == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }

        reunionRepository.findAll().forEach(reunion -> reunion.setStatus(status));
    }

    public Integer reunionActiveStatus() {
        return getReunionActive().getStatus();
    }
}
