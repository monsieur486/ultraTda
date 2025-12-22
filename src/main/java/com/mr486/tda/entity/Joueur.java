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
@Table(name = "joueurs")
public class Joueur {

    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private Integer amiId;

    public Joueur(Integer amiId) {
        this.amiId = amiId;
    }
}
