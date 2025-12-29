package com.mr486.tda.dto;

import com.mr486.tda.model.Ami;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AmiListe {

    private Integer id;
    private String nom;

    public AmiListe(Ami ami) {
        this.id = ami.getId();
        String nom = ami.getNom();
        if (ami.getIsGuest()) {
            nom += "*";
        }
        this.nom = nom;
    }
}
