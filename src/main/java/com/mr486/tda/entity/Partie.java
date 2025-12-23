package com.mr486.tda.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "parties")
public class Partie {

    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    private Integer nombreJoueurs = 0;
    private Integer contratId = 0;
    private Integer preneurId = 0;
    private Integer appelId = 0;
    private Integer mortId = 0;
    private Boolean estFait = false;
    private Integer score = 0;
    private Integer petitAuBoutId = 0;
    private Boolean chelem = false;
    private Boolean capot = false;
}
